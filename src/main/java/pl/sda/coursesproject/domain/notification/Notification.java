package pl.sda.coursesproject.domain.notification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.coursesproject.domain.lesson.Lesson;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
@NoArgsConstructor
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Lesson lesson;

    @Column
    private String subject;

    @Column
    private String content;

}
