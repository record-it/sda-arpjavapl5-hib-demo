package entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

//encja z polami
//name
//email
//album
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student extends AbstractEntity{

    private String name;

    private String email;

    @Embedded
    private Album album;
}
