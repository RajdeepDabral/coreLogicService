package dabral.rajdeep.CoreLogicService.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex , WebRequest request){
        ex.printStackTrace();
        ResponseException responseException = new ResponseException(ex.getMessage(),new Date());
        return new ResponseEntity(responseException , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<ResponseException> handleNullPointerExceptions(NullPointerException ex , WebRequest request){
        ResponseException responseException = new ResponseException("null pointer exception.",new Date());
        return new ResponseEntity(responseException , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<ResponseException> handleProductNotFoundExceptions(ProductNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public final ResponseEntity<ResponseException> handleSellerNotFoundExceptions(SellerNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public final ResponseEntity<ResponseException> handleCategoryNotFoundExceptions(CategoryNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<ResponseException> handleCustomerNotFoundExceptions(CustomerNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidTokenException.class)
    public final ResponseEntity<ResponseException> handleInvalidTokenExceptions(InvalidTokenException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(AddressNotFoundException.class)
    public final ResponseEntity<ResponseException> handleAddressNotFoundExceptions(AddressNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MetaNotFoundException.class)
    public final ResponseEntity<ResponseException> handleMetaNotFoundExceptions(MetaNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerExistsException.class)
    public final ResponseEntity<ResponseException> handleCustomerExistsExceptions(CustomerExistsException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(PasswordNotMatchException.class)
    public final ResponseEntity<ResponseException> handlePasswordNotMatchExceptions(PasswordNotMatchException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ProductQuantityException.class)
    public final ResponseEntity<ResponseException> handleProductQuantityExceptions(ProductQuantityException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(ProductVariationExistsInCartException.class)
    public final ResponseEntity<ResponseException> handleProductVariationExistsInCartExceptions(ProductVariationExistsInCartException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(ProductVariationNotFoundException.class)
    public final ResponseEntity<ResponseException> handleProductVariationNotFoundExceptions(ProductVariationNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CartEmptyException.class)
    public final ResponseEntity<ResponseException> handleCartEmptyExceptions(CartEmptyException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OrderProductNotFoundException.class)
    public final ResponseEntity<ResponseException> handleOrderProductNotFoundExceptions(OrderProductNotFoundException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidStatusException.class)
    public final ResponseEntity<ResponseException> handleInvalidStatusExceptions(InvalidStatusException ex , WebRequest request){
        ResponseException responseException =  new ResponseException(ex.getMessage(), new Date());
        return new ResponseEntity<>(responseException , HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ErrorResponse apiError = new ErrorResponse(ex.getLocalizedMessage(), errors,HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }




}
