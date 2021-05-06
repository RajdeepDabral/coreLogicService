package dabral.rajdeep.CoreLogicService.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidationImpl.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneValidation {
    String message() default "invalid phone number.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
