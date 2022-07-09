package entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product extends AbstractEntity{
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private int quantity;
}
