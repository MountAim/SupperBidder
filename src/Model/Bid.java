package Model;

public class Bid {
    int bidId;
    Buyer buyer;
    int amount;
    int auctionId;
    String auctionName;

    public Bid(int bidId, Buyer buyer, int auctionId,int amount) {
        this.bidId = bidId;
        this.buyer = buyer;
        this.amount = amount;
        this.auctionId = auctionId;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }
}
