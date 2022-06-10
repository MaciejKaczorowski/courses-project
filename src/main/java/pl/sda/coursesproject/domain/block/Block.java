package pl.sda.coursesproject.domain.block;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.lesson.Lesson;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blocks")
@NoArgsConstructor
@Getter
@Setter
public class Block {
    public Block(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "block")
    private List<Lesson> lessons;

    @ManyToMany(mappedBy = "blocks")
    private List<Course> courses = new ArrayList<>();

    @Override
    public String toString() {
        return "Block{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
