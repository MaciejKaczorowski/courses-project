package pl.sda.coursesproject.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import pl.sda.coursesproject.domain.role.Role;

import javax.persistence.*;

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
    private boolean isActive;


}
