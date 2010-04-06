package org.goos.auction;

import org.junit.After;
import org.junit.Test;

public class AuctionSniperEndToEndTest {

  private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");

  private final ApplicationRunner application = new ApplicationRunner();

  @Test
  public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
    auction.startSellingItem(); // Step 1, cut a hole in a box
    application.startBiddingIn(auction); // Step 2
    auction.hasReceivedJoinRequestFromSniper(); // Step 3
    auction.announceClosed(); // Step 4
    application.showsSniperHasLostAuction(); // Step 5
  }

  @Test
  public void sniperMakesAHigherBigButLoses() throws Exception {
    auction.startSellingItem();

    application.startBiddingIn(auction);
    auction.hasReceivedJoinRequestFrom(ApplicationRunner.SNIPER_XMPP_ID);

    auction.reportPrice(1000, 98, "other bidder");
    application.hasShownSniperIsBidding();

    auction.hasReceivedBid(1089, ApplicationRunner.SNIPER_XMPP_ID);

    auction.announceClosed();
    application.showsSniperHasLostAuction();
  }

  @After
  public void stopAuction() {
    auction.stop();
  }

  @After
  public void stopApplication() {
    application.stop();
  }

}
