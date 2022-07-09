package entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.sql.Timestamp;
import java.time.LocalDateTime;

//Klasa osadzana w Student
//pola
//number (liczba int)
//registered (Timestamp)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Embeddable
public class Album {
    private int number;

    private Timestamp registered;

    @PrePersist
    private void register(){
        registered = Timestamp.valueOf(LocalDateTime.now());
    }
}
