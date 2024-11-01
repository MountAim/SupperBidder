package Service;

import Database.AuctionRepository;
import Database.BuyerRepository;

import Mode.ConsolePrint;
import Mode.Print;
import Model.Auction;
import Model.Bid;
import Model.Buyer;
import Exception.*;

import java.util.List;


public class BuyerService {
    BuyerRepository buyerRepository;
    AuctionRepository auctionRepository;
    Print print = new ConsolePrint();

    public BuyerService(BuyerRepository buyerRepository, AuctionRepository auctionRepository) {
        this.buyerRepository = buyerRepository;
        this.auctionRepository = auctionRepository;
    }

    public void registerUser(Buyer buyer){
        buyerRepository.registerUser(buyer);
        print.printData("Buyer "+buyer.getName()+" added successfully.");
    }

//    public void addUserBudget(Buyer buyer, int budget) {
//        if(!buyerRepository.isUserRegistered(buyer.getUserId())){
//            throw new InvalidUserException("Buyer not Found");
//        }
//        buyerRepository.addUserBudget(buyer, budget);
//    }

    public void createBid(Bid bid) {
        if(buyerRepository.getBuyerMap().containsKey(bid.getBuyer().getUserId())){
            throw new InvalidUserException("User does not exist");
        }

        int auctionId = bid.getAuctionId();
        if(!auctionRepository.getAuctionMap().containsKey(auctionId)){
            throw new InvalidAuctionException("Auction doesn't exist");
        }

        if(!auctionRepository.getAuctionMap().get(auctionId).getIsOpen()){
            throw new InvalidAuctionException("Auction closed.");
        }

        Auction auction = auctionRepository.getAuctionMap().get(auctionId);
        List<Bid> bidList = auction.getBidList();
        bidList.add(bid);
        auction.setBidList(bidList);
        auctionRepository.getAuctionMap().put(auctionId, auction);
        print.printData("Bid of " + bid.getAmount() +" by " + bid.getBuyer().getName() + " is placed.");
    }

//    public void updateBid(User user, Bid bid, Auction auction) {
//        if(!buyerRepository.isUserRegistered(user.getUserId())){
//            throw new InvalidUserException("Buyer not Found");
//        }
//        if(buyerRepository.getUser(user.getUserId()).budget < bid.getAmount()){
//            throw new InsufficientBalanceException("Insufficient Balance");
//        }
//        if(auctionRepository.isAuctionRegistered(auction.getAuctionId())){
//            throw new InvalidAuctionException("Auction does not exist");
//        }
//        if((auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount()) &&
//                (auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount())){
//            throw new OutOfRangeException("Invalid Bid Amount");
//        }
//        buyerRepository.placeBid(user, bid, auction);
//    }
//
//    public void placeBid(User user, Bid bid, Auction auction) {
//        if(!buyerRepository.isUserRegistered(user.getUserId())){
//            throw new InvalidUserException("Buyer not Found");
//        }
//        if(buyerRepository.getUser(user.getUserId()).budget < bid.getAmount()){
//            throw new InsufficientBalanceException("Insufficient Balance");
//        }
//        if(auctionRepository.isAuctionRegistered(auction.getAuctionId())){
//            throw new InvalidAuctionException("Auction does not exist");
//        }
//        if((auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount()) &&
//                (auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount())){
//            throw new OutOfRangeException("Invalid Bid Amount");
//        }
//        buyerRepository.placeBid(user, bid, auction);
//    }


}
