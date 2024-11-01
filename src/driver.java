import Database.AuctionRepository;
import Database.BuyerRepository;
import Database.SellerRepository;
import Mode.ConsolePrint;
import Mode.Print;
import Model.*;
import Service.AuctionService;
import Service.BuyerService;
import Service.SellerService;

public class driver {
    public  static void main(String[] args){
        BuyerRepository buyerRepository = new BuyerRepository();
        SellerRepository sellerRepository = new SellerRepository();
        AuctionRepository auctionRepository = new AuctionRepository();

        BuyerService buyerService = new BuyerService(buyerRepository, auctionRepository);
        SellerService sellerService = new SellerService(sellerRepository, auctionRepository);
        AuctionService auctionService = new AuctionService(auctionRepository);

        Print print = new ConsolePrint();

        Buyer buyer1 = new Buyer(1,"Joe",100);
        Buyer buyer2 = new Buyer(2,"Monica",200);
        Buyer buyer3 = new Buyer(3,"Ross",300);
        buyerService.registerUser(buyer1);
        buyerService.registerUser(buyer2);
        buyerService.registerUser(buyer3);

        Seller seller1 = new Seller(1,"Chandler");
        sellerService.registerUser(seller1);

        Auction auction1 = new Auction(1, 10,150, seller1);
        auctionService.createAuction(auction1);

        Bid bid1 = new Bid(1, buyer1, auction1.getAuctionId(),17);
        Bid bid2 = new Bid(2, buyer2, auction1.getAuctionId(),15);
        Bid bid3 = new Bid(3, buyer2, auction1.getAuctionId(),19);
        Bid bid4 = new Bid(4, buyer3, auction1.getAuctionId(),19);


        buyerService.createBid(bid1);
        buyerService.createBid(bid2);
        buyerService.createBid(bid3);
        buyerService.createBid(bid4);

        Bid winningBid = auctionService.closeAuction(auction1.getAuctionId());

        print.printData(winningBid.getBuyer().getName() + " wins the bid by placing bid of " + winningBid.getAmount());

//        ADD_BUYER("buyer1")
//        ADD_BUYER("buyer2")
//        ADD_BUYER("buyer3")
//        ADD_SELLER("seller1")
//        CREATE_AUCTION("A1", "10", "50", "seller1")
//        CREATE_BID("buyer1", "A1", "17")
//        CREATE_BID("buyer2", "A1", "15")
//        UPDATE_BID("buyer2", "A1", "19")
//        CREATE_BID("buyer3", "A1", "19")
//        CLOSE_AUCTION("A1")

//
//        ADD_SELLER("seller2")
//        CREATE_AUCTION("A2", "5", "20", "seller2")
//        CREATE_BID("buyer3", "A2", 25)
//        This should fail as the highest bid limit is 20 for A2.
//                CREATE_BID("buyer2", "A2", 5)
//        WITHDRAW_BID("buyer2", "A2")
//        CLOSE_AUCTION("A2")

    }
}
