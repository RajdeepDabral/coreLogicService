package dabral.rajdeep.CoreLogicService.Entities;

import dabral.rajdeep.CoreLogicService.Enum.AddressType;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String state;
    private String country;
    private String line;
    private String zipCode;
    @Enumerated(EnumType.STRING)
    private AddressType type;
    private String name;


    public Address(String city, String state, String country, String line, String zipCode, AddressType type,
                   String name) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.line = line;
        this.zipCode = zipCode;
        this.type = type;
        this.name = name;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
