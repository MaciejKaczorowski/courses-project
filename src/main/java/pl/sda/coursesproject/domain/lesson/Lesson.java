package pl.sda.coursesproject.domain.lesson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.coursesproject.domain.block.Block;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String topic;

    @Column (nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime dateTime;

    @ManyToOne
    private Block block;

}
