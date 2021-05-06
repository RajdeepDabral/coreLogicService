package dabral.rajdeep.CoreLogicService.Service.Impl;

import dabral.rajdeep.CoreLogicService.Entities.Customer;
import dabral.rajdeep.CoreLogicService.Entities.CustomerDTO;
import dabral.rajdeep.CoreLogicService.Entities.Role;
import dabral.rajdeep.CoreLogicService.Repository.CustomerRepository;
import dabral.rajdeep.CoreLogicService.Service.CustomerService;
import dabral.rajdeep.CoreLogicService.Service.EmailService;
import dabral.rajdeep.CoreLogicService.Service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    TokenService tokenService;

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerServiceImpl.class);


    public boolean createNewCustomer(CustomerDTO customer){
        Customer customerTemp =null;
        String token=null;
        String subject = "shopping_store : customer register successfully.";
        StringBuilder message = new StringBuilder();
        customerTemp = customerRepository.findByEmail(customer.getEmail());
        if(customerTemp != null){
//            throw new CustomerExistsException("customer email id exits.");
            LOGGER.warn("customer email id exits.");
            return false;
        }
        if(!customer.getPassword().equals(customer.getConfirmPassword())){
//            throw new PasswordNotMatchException("password and confirm password not match.");
            LOGGER.warn("password and confirm password not match.");
            return false;
        }
        customerTemp =  new Customer();
        customerTemp.setEmail(customer.getEmail());
        customerTemp.setFirstName(customer.getFirstName());
        customerTemp.setLastName(customer.getLastName());
        customerTemp.setMiddleName(customer.getMiddleName());
        customerTemp.setAddressList(customer.getAddressList());
        customerTemp.setPassword(customer.getPassword());
//        customerTemp.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerTemp.setPhoneNumber(customer.getPhoneNumber());
        customerTemp.setActive(false);
        customerTemp.setDeleted(false);
        customerTemp.setRoleList(Arrays.asList(new Role("ROLE_CUSTOMER")));

        token = tokenService.generateToken();
        if (token == null) {
            LOGGER.warn("unable to generate token.");
            return false;
        }
        LOGGER.info("token generated.");
        customerTemp.setToken(token);
        customerTemp.setTokenGenerateTime(new Date(System.currentTimeMillis()));
        customerTemp.setProfileImage(null);
        customerRepository.save(customerTemp);
        LOGGER.info("customer saved to db.");
        message.append("Hi, customer you successfully register.\n\n your activation token is \n "+ token);

        LOGGER.info("Email send :" +emailService.sendEmail(subject,message.toString(),customerTemp.getEmail()));
        return true;
    }
}
