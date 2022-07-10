package entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SecondaryTable(name = "departments")
public class Worker extends AbstractEntity{
    private String position;

    private double salary;

    @OneToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Column(table = "departments", name = "name")
    private String departmentName;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Tool> tools = new ArrayList<>();

    @Override
    public String toString() {
        String toolString = "";
        for (Tool tool: tools) {
            toolString += tool.getName() + ", ";
        }
        return position +", " + salary + ", " + departmentName +", tools: " + toolString;
    }
}
