package pl.sda.coursesproject.domain.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.sda.coursesproject.domain.block.Block;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Block> blocks;

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
