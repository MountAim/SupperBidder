package Service;

import Database.AuctionRepository;
import Mode.ConsolePrint;
import Mode.Print;
import Model.Auction;
import Model.Bid;
import Utils.BidAmountComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Comparator;
import Exception.*;



public class AuctionService {

    AuctionRepository auctionRepository;
    Print print = new ConsolePrint();

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public void createAuction(Auction auction){
        auctionRepository.getAuctionMap().put(auction.getAuctionId(),auction);
        print.printData("Auction for " + auction.getAuctionName() + " is created successfully.");
    }

    public Bid closeAuction(int auctionId){
        if(!auctionRepository.auctionMap.containsKey(auctionId)){
            throw new InvalidAuctionException("Auction doesn't exist.");
        }
        if(!auctionRepository.auctionMap.get(auctionId).getIsOpen()){
            throw new InvalidAuctionException("Auction is closed.");
        }
        Auction auction = auctionRepository.getAuctionMap().get(auctionId);
        List<Bid> bidList = auction.getBidList();
        Collections.sort(bidList, new BidAmountComparator());

        int cnt = 1;
        for(int i = 1; i < bidList.size(); ++ i){
            if(bidList.get(i - 1).getAmount() == bidList.get(i).getAmount()){
                ++ cnt;
            }
            else {
                if(cnt == 1){
                    auction.setIsOpen(false);
                    return bidList.get(i - 1);
                }
                cnt = 1;
            }
        }
        auction.setIsOpen(false);
        return bidList.get(bidList.size() - 1);
    }

//    public void placeBid(User user, Bid bid, Auction auction) {
//        if(!buyerRepository.isUserRegistered(user.getUserId())){
//            throw new InvalidUserException("Buyer not Found");
//        }
//        if(buyerRepository.getUser(user.getUserId()).budget < bid.getAmount()){
//            throw new InsufficientBalanceException("Insufficient Balance");
//        }
//        AuctionService auctionService;
//        if(!auctionService.isAuctionRegistered(auction.getAuctionId())){
//            throw new InvalidAuctionException("Auction does not exist");
//        }
//        if((auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount()) &&
//                (auctionRepository.getAuction(auction.getAuctionId()).minimumAmount <= bid.getAmount())){
//            throw new OutOfRangeException("Invalid Bid Amount");
//        }
//        buyerRepository.placeBid(user, bid, auction);
//    }
}
