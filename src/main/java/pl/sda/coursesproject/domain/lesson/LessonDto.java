package pl.sda.coursesproject.domain.lesson;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.exception.DataException;

import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LessonDto {

    private Long id;
    private String topic;
    private LocalDateTime dateTime;


}
