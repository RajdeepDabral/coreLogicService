package dabral.rajdeep.CoreLogicService.Exceptions;

public class OrderProductNotFoundException extends  RuntimeException{
    public OrderProductNotFoundException(String message) {
        super(message);
    }
}
