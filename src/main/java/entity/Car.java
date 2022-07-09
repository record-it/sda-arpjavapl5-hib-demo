package entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Car extends AbstractEntity{
    @Column(name = "power", nullable = false)
    private double power;

    @Column(name="model", length = 50)
    private String model;

    @Column(name="price", precision = 8, scale = 2)
    private BigDecimal price;

    @Column(name = "dostepny")
    private Boolean available;

}
