package pl.sda.coursesproject.domain.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Lesson getLessonByTopic(String topic);

    List<Lesson> getLessonsByDateTime(LocalDateTime dateTime);


}
