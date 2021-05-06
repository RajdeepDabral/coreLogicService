package dabral.rajdeep.CoreLogicService.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidationImpl.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {

    String message() default "Invalid email id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
