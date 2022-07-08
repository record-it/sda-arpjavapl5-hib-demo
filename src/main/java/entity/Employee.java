package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Persistence;
import java.math.BigDecimal;
//Klasa z kluczem złożonym
@Entity
public class Employee {

    @EmbeddedId
    private PersonId id;

    private BigDecimal salary;
}
