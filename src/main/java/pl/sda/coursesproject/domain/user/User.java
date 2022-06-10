package pl.sda.coursesproject.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.role.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    private String password;

    @ManyToOne
    private Role role;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(name="is_active")
    private boolean active;

    @ManyToMany
    @JoinTable(name = "users_courses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();

    public User(String login, String password, String name, String surname, boolean active) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.active = active;
    }
}
