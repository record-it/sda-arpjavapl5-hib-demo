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
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String position;

    private double salary;

    @OneToOne
    private Car car;
}
