package org.goos.auction;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class FakeAuctionServer {
	  public static final String ITEM_ID_AS_LOGIN = "auction-";
	  public static final String AUCTION_RESOURCE = "Auction";
	  public static final String XMPP_HOSTNAME = "localhost";
	  private static final String AUCTION_PASSWORD = "auction";

	  private final String itemId;
	  private final XMPPConnection connection;
	  private Chat currentChat;

	  public FakeAuctionServer(String itemId) {
	    this.itemId = itemId;
	    this.connection = new XMPPConnection(XMPP_HOSTNAME);
	  }

	  public void startSellingItem() throws XMPPException {
	    connection.connect();
	    connection.login(format(ITEM_ID_AS_LOGIN, itemId),
	                     AUCTION_PASSWORD, AUCTION_RESOURCE);
	    connection.getChatManager().addChatListener(
	      new ChatManagerListener() {
	        public void chatCreated(Chat chat, boolean createdLocally) {
	          currentChat = chat;
	        }
	      });
	  }

	  private String format(String itemIdAsLogin, String itemId2) {
		return new StringBuilder().append(itemIdAsLogin).append(itemId2).toString();
	}

	public String getItemId() {
	    return itemId;
	  }
}
