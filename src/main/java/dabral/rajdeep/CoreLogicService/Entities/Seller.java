package dabral.rajdeep.CoreLogicService.Entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="User_Id")
public class Seller extends User {
    private String gst;
    private String companyContact;
    private String companyName;

    public Seller(){
    }

    public Seller(String gst, String companyContact, String companyName) {
        this.gst = gst;
        this.companyContact = companyContact;
        this.companyName = companyName;
    }

    public Seller(Integer id, String email, String firstName, String middleName, String lastName, String password, Boolean isDeleted, Boolean isActive, String token, Date tokenGenerateTime, List<Address> addressList, List<Role> roleList, String gst, String companyContact, String companyName) {
        super(id, email, firstName, middleName, lastName, password, isDeleted, isActive, token, tokenGenerateTime, addressList, roleList);
        this.gst = gst;
        this.companyContact = companyContact;
        this.companyName = companyName;
    }

    public Seller(Integer id, String email, String firstName, String middleName, String lastName, String password, String phoneNumber, String profileImage, Boolean isDeleted, Boolean isActive, String token, Date tokenGenerateTime, List<Address> addressList, List<Role> roleList, String gst, String companyContact, String companyName) {
        super(id, email, firstName, middleName, lastName, password, phoneNumber, profileImage, isDeleted, isActive, token, tokenGenerateTime, addressList, roleList);
        this.gst = gst;
        this.companyContact = companyContact;
        this.companyName = companyName;
    }

    public Seller(String email, String firstName, String middleName, String lastName, String password, Boolean isDeleted, Boolean isActive, String gst, String companyContact, String companyName) {
        super(email, firstName, middleName, lastName, password, isDeleted, isActive);
        this.gst = gst;
        this.companyContact = companyContact;
        this.companyName = companyName;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
