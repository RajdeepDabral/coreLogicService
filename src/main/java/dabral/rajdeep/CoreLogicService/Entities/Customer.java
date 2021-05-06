package dabral.rajdeep.CoreLogicService.Entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="User_Id")
public class Customer extends User{
    public Customer() {
    }

    public Customer(Integer id, String email, String firstName, String middleName, String lastName, String password, Boolean isDeleted, Boolean isActive, String token, Date tokenGenerateTime, List<Address> addressList, List<Role> roleList) {
        super(id, email, firstName, middleName, lastName, password, isDeleted, isActive, token, tokenGenerateTime, addressList, roleList);
    }

    public Customer(Integer id, String email, String firstName, String middleName, String lastName, String password, String phoneNumber, String profileImage, Boolean isDeleted, Boolean isActive, String token, Date tokenGenerateTime, List<Address> addressList, List<Role> roleList) {
        super(id, email, firstName, middleName, lastName, password, phoneNumber, profileImage, isDeleted, isActive, token, tokenGenerateTime, addressList, roleList);
    }

    public Customer(String email, String firstName, String middleName, String lastName, String password, Boolean isDeleted, Boolean isActive) {
        super(email, firstName, middleName, lastName, password, isDeleted, isActive);
    }

    @Override
    public String toString() {
        return "Customer{} " + super.toString();
    }
}
