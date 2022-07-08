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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "power", nullable = false)
    private double power;

    @Column(name="model", length = 50)
    private String model;

    @Column(name="price", precision = 8, scale = 2)
    private BigDecimal price;

    @Column(name = "dostepny")
    private Boolean available;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
