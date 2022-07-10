package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Article extends AbstractEntity {
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Author> authors;
}
