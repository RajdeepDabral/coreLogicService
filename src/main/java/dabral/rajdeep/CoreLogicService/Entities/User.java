package dabral.rajdeep.CoreLogicService.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String profileImage;
    @JsonProperty
    private Boolean isDeleted;
    @JsonProperty
    private Boolean isActive;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date tokenGenerateTime;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Address> addressList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roleList;

    public User() {
    }

    public User(Integer id, String email, String firstName, String middleName, String lastName,
                String password, Boolean isDeleted, Boolean isActive, String token, Date tokenGenerateTime,
                List<Address> addressList, List<Role> roleList) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.token = token;
        this.tokenGenerateTime = tokenGenerateTime;
        this.addressList = addressList;
        this.roleList = roleList;
    }

    public User(Integer id, String email, String firstName, String middleName, String lastName, String password,
                String phoneNumber, String profileImage, Boolean isDeleted, Boolean isActive, String token,
                Date tokenGenerateTime, List<Address> addressList, List<Role> roleList) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.token = token;
        this.tokenGenerateTime = tokenGenerateTime;
        this.addressList = addressList;
        this.roleList = roleList;
    }

    public User(String email, String firstName, String middleName, String lastName, String password,
                Boolean isDeleted, Boolean isActive) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
    }

    public Date getTokenGenerateTime() {
        return tokenGenerateTime;
    }

    public void setTokenGenerateTime(Date tokenGenerateTime) {
        this.tokenGenerateTime = tokenGenerateTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}