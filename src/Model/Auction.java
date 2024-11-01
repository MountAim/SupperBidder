package Model;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    int auctionId;
    int minimumAmount;
    int maximumAmount;
    String auctionName;
    Seller seller;
    List<Bid> bidList;
    boolean isOpen;


    public Auction(int auctionId,int minimumAmount, int maximumAmount, Seller seller){
        this.auctionId = auctionId;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.seller = seller;
        this.bidList = new ArrayList<>();
        isOpen = true;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public List<Bid> getBids() {
        return bidList;
    }

    public void setBids(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }


}
