package Database;

import Model.Auction;

import java.util.HashMap;
import java.util.Map;

public class AuctionRepository {
    public Map<Integer,Auction> auctionMap = new HashMap<>();


    public Map<Integer, Auction> getAuctionMap() {
        return auctionMap;
    }

    public void setAuctionMap(Map<Integer, Auction> auctionMap) {
        this.auctionMap = auctionMap;
    }
}
