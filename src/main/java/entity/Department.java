package entity;

import javax.persistence.*;

@Entity
@Table(name= "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
}
