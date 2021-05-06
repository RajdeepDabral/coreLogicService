package dabral.rajdeep.CoreLogicService.Exceptions;

public class CartEmptyException extends RuntimeException{
    public CartEmptyException(String message) {
        super(message);
    }
}
