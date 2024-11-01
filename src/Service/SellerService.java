package Service;

import Database.AuctionRepository;
import Database.SellerRepository;
import Mode.ConsolePrint;
import Mode.Print;
import Model.Auction;
import Model.Seller;

public class SellerService {
    SellerRepository sellerRepository;
    AuctionRepository auctionRepository;
    Print print = new ConsolePrint();

    public SellerService(SellerRepository sellerRepository, AuctionRepository auctionRepository){
        this.sellerRepository = sellerRepository;
        this.auctionRepository = auctionRepository;
    }

    public void registerUser(Seller seller){
        sellerRepository.registerUser(seller);
        print.printData("Seller "+seller.getName()+" added successfully.");
    }

}
