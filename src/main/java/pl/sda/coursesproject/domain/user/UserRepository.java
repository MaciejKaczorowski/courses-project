package pl.sda.coursesproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

    List<User> getUsersBySurname (String lastName);



}
