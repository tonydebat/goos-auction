package org.goos.auction;

import org.junit.After;
import org.junit.Test;


public class AuctionSniperEndToEndTest {
	
	private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
	private final ApplicationRunner application = new ApplicationRunner();
	
	@Test
	public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
		auction.startSellingItem();                 // Step 1, cut a hole in a box
		application.startBiddingIn(auction);        // Step 2
//		auction.hasReceivedJoinRequestFromSniper(); // Step 3
//		auction.announceClosed();                   // Step 4
		application.showsSniperHasLostAuction();    // Step 5
	}
	
	@After public void stopAuction() {
//		auction.stop();
	}
	
	@After public void stopApplication() {
		application.stop();
	}
	
	
}
