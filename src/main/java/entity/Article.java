package entity;

import lombok.*;

import javax.persistence.*;
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
@NamedQuery(name = "programming", query = "select a from Article a join a.tags t where t.name = 'Programming'")
public class Article extends AbstractEntity {
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Author> authors;
}
