package dabral.rajdeep.CoreLogicService.Exceptions;

public class ProductVariationExistsInCartException extends  RuntimeException{
    public ProductVariationExistsInCartException(String message) {
        super(message);
    }
}
