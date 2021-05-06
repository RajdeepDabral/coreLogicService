package dabral.rajdeep.CoreLogicService.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidationImpl implements ConstraintValidator<PasswordValidation, String> {

    @Override
    public void initialize(PasswordValidation password) {
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean lengthFlag=false;
        boolean specialFlag=false;
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        if(password == null){
            return false;
        }
        if(password.isEmpty()){
            return false;
        }
        if(password.length()>=8 && password.length()<=15){
            lengthFlag=true;
            System.out.println("password length correct!!!");
        }else{
            lengthFlag=false;
        }
        for(int i=0; i<password.length();i++) {
            ch = password.charAt(i);
            if( Character.isDigit(ch) && numberFlag==false) {
                System.out.println("digit found!!!");
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch) && capitalFlag ==false) {
                System.out.println("uppercase found!!!");
                capitalFlag = true;
            } else if (Character.isLowerCase(ch) && lowerCaseFlag ==false) {
                System.out.println("lowercase found!!!");
                lowerCaseFlag = true;
            }else if(specialCharactersString.contains(Character.toString(ch)) && specialFlag ==false)
            {
                System.out.println("special case  found!!!");
                specialFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag && lengthFlag && specialFlag)
                return true;
        }
        return false;
    }
}
