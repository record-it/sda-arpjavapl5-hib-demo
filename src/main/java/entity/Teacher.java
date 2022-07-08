package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonId.class)
public class Teacher {
    @Id
    private String lastName;

    @Id
    private String pesel;

    private String subject;
}
