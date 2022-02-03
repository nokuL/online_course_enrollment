package rc.bootsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street;

    private String surbub;

    private String city;

    public Address(){}

    public Address(String street, String surbub, String city) {
        this.street = street;
        this.surbub = surbub;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSurbub() {
        return surbub;
    }

    public void setSurbub(String surbub) {
        this.surbub = surbub;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
