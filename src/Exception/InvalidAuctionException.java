package Exception;

public class InvalidAuctionException extends RuntimeException {
    public InvalidAuctionException(String message) {
        super(message);
    }
}
