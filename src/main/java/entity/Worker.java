package entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "workers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@SecondaryTable(name = "departments")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String position;

    private double salary;

    @OneToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Column(table = "departments", name = "name")
    private String departmentName;
}
