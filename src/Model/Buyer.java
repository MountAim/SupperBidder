package Model;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int buyerId;
    private String name;
    private int budget;
    private List<Auction> auctionList;

    // Constructor
    public Buyer(int buyerId, String name, int budget) {
        this.name = name;
        this.budget = budget;
        this.auctionList = new ArrayList<>();
        this.buyerId = buyerId;
    }


    public int getUserId() {
        return buyerId;
    }


    public void setUserId(int buyerId) {
        this.buyerId = buyerId;
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

    // Buyer-specific methods
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
