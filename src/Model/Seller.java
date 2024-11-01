package Model;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private int sellerId;
    private String name;
    private List<Auction> auctionList;  // List of auctions hosted by this seller

    // Constructor
    public Seller(int sellerId, String name) {
        this.sellerId = sellerId;
        this.name = name;
        this.auctionList = new ArrayList<>();
    }

    public int getUserId() {
        return sellerId;
    }

    public void setUserId(int sellerId) {
        this.sellerId = sellerId;
    }

    // Implement methods from User interface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }
}
