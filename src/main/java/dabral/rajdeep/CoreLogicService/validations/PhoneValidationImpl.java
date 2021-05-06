package dabral.rajdeep.CoreLogicService.validations;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneValidationImpl implements ConstraintValidator<PhoneValidation, String> {

    @Override
    public void initialize(PhoneValidation phone) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext cxt) {
        if (phone == null) {
            return false;
        }
        if (phone.length() < 0 || phone.length() > 10) {
            return false;
        }
        String regex = "[7-9][0-9]{9}";
        System.out.println("is mobile no. valid :" + phone.matches(regex));
        if (phone.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}


