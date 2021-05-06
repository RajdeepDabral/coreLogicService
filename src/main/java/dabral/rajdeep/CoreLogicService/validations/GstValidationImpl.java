package dabral.rajdeep.CoreLogicService.validations;

//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class GstValidationImpl implements ConstraintValidator<GstValidation, String> {
//
//    @Autowired
//    SellerRepository sellerRepository;
//
//    @Override
//    public void initialize(GstValidation gst) {
//    }
//
//    @Override
//    public boolean isValid(String gst, ConstraintValidatorContext cxt) {
//        Seller sellerTemp = null;
//        sellerTemp = sellerRepository.findByGst(gst);
//        if (sellerTemp != null) {
//            System.out.println("gst number already exits!!!");
//            return false;
//        }
//        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$";
//        Pattern p = Pattern.compile(regex);
//        if (gst == null) {
//            System.out.println("gst is not valid!!!");
//            return false;
//        }
//        Matcher m = p.matcher(gst);
//        return m.matches();
//    }
//}
