package dabral.rajdeep.CoreLogicService.Controller;

import dabral.rajdeep.CoreLogicService.Entities.CustomerDTO;
import dabral.rajdeep.CoreLogicService.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/register")
    public Boolean registerCustomer(@RequestBody CustomerDTO customer) {
        boolean result= false;
        result = customerService.createNewCustomer(customer);
        if(result == true) {
            return true;
        }else{
            return false;
        }
    }
}
