package pl.sda.coursesproject.domain.registration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;



public class UserRegistration {


    private Long id;

    private LocalDate date;

    private User user;

    private Course course;

}
