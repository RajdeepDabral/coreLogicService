package dabral.rajdeep.CoreLogicService.Exceptions;

public class CustomerExistsException extends  RuntimeException{
    public CustomerExistsException(String message) {
        super(message);
    }
}
