package pl.sda.coursesproject.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.coursesproject.domain.course.Course;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String login;
    private String name;
    private String surname;
    private boolean active;

    private List<Course> courses;

}
