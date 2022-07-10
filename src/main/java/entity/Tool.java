package entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Tool extends AbstractEntity{
    private String name;

    @ManyToOne(targetEntity = Worker.class)
    private Worker worker;
}
