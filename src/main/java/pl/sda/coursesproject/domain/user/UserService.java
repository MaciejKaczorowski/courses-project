package pl.sda.coursesproject.domain.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.course.CourseRepository;
import pl.sda.coursesproject.domain.role.Role;
import pl.sda.coursesproject.domain.role.RoleRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CourseRepository courseRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public void saveUser(User user) {
        if (user.getRole() != null) {
            Role role = roleRepository.getById(user.getRole().getId());
            user.setRole(role);
        }
        userRepository.save(user);
    }

    public User findUserWithCoursesBySurname(String surname) {
        return userRepository.getUsersWithCourses(surname);
    }

    @Transactional
    public User addCourseToUser (Long courseId, Long userId) {
        Course course = courseRepository.getById(courseId);
        User user = userRepository.getById(userId);
        Set<Course> courses = user.getCourses();
        courses.add(course);
        user.setCourses(courses);
        return userRepository.save(user);
    }

    public void removeUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new IllegalStateException("Failed to remove User. Invalid UserId :: " + userId);
        }
        userRepository.delete(user.get());
    }

    public User getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public List<User> getBySurname(String surname) {
        return userRepository.getUsersBySurname(surname);
    }

    public List<User> displayAllUsers (){
        return userRepository.findAll();
    }

    public Authentication getLoggedUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


}
