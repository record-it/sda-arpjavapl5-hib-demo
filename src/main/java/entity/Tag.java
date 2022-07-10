package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag extends AbstractEntity{
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles;

    @Override
    public String toString() {
        return String.format("Tag {id: %d name: %s}", getId(), name);
    }
}
