package Database;

import Model.Auction;
import Model.Seller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerRepository {

    Map<Integer, Seller> sellerMap = new HashMap<>();
    Map<Integer, List<Auction>> sellerAuctionMap = new HashMap<>();

    public void registerUser(Seller seller){
        sellerMap.put(seller.getUserId(), seller);
    }
}
