package dabral.rajdeep.CoreLogicService.validations;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidationImpl implements ConstraintValidator<EmailValidation, String> {

    @Override
    public void initialize(EmailValidation email) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        if(email==null){
            return false;
        }
        System.out.println("email id not null!!!");
        try {
            InternetAddress emailAdd = new InternetAddress(email);
            emailAdd.validate();
        } catch (AddressException ex) {
            return false;
        }
        System.out.println("email id is valid!!!");
        return true ;
    }
}
