package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Address {
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "street", length = 100)
    private String street;
    @Column(name = "zip_code", length = 6)
    private String zipCode;
}
