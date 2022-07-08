package entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Embeddable
public class PersonId implements Serializable {
    private String lastName;

    private String pesel;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
