package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author extends AbstractEntity{
    private String email;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Article> articles;
}
