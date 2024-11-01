package Database;

import Model.Auction;
import Model.Bid;
import Model.Buyer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyerRepository {

    Map<Integer, Buyer> buyerMap = new HashMap<>();
    Map<Integer, List<Auction>> buyerAuctionMap = new HashMap<>();


    public void registerUser(Buyer buyer){
        buyerMap.put(buyer.getUserId(), buyer);
    }

    public Map<Integer, List<Auction>> getBuyerAuctionMap() {
        return buyerAuctionMap;
    }

    public void setBuyerAuctionMap(Map<Integer, List<Auction>> buyerAuctionMap) {
        this.buyerAuctionMap = buyerAuctionMap;
    }

    public Map<Integer, Buyer> getBuyerMap() {
        return buyerMap;
    }

    public void setBuyerMap(Map<Integer, Buyer> buyerMap) {
        this.buyerMap = buyerMap;
    }
    //    public void addUserBudget(User user, int budget) {
//        buyerMap.put(user.getUserId(), (buyerMap.get(user.getUserId())).getBudget() + budget);
//    }
//
//    public void isUserRegistered(User user){
//        if(buyerMap.containsKey(user.getUserId()))
//    }
//    public void placeBid(User user, Bid bid, Auction auction) {
//        List<Auction> auctions = buyerAuctionMap.get(user.getUserId());
//        // If the list does not exist, create a new one
//        if (auctions == null) {
//            auctions = new ArrayList<>();
//            buyerAuctionMap.put(user.getUserId(), auctions);
//        }
//        // Add the auction to the list
//        auctions.add(auction);
//
//    }
//
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
