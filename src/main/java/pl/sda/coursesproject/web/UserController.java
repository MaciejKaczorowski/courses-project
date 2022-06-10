package pl.sda.coursesproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.coursesproject.domain.course.CourseService;
import pl.sda.coursesproject.domain.role.RoleService;
import pl.sda.coursesproject.domain.user.User;
import pl.sda.coursesproject.domain.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final CourseService courseService;
    private final UserService userService;
    private final RoleService roleService;

    public UserController(CourseService courseService, UserService userService, RoleService roleService) {
        this.courseService = courseService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String list(Model model){
        List<User> allUsers = userService.displayAllUsers();
        model.addAttribute("users", allUsers);
        return "usersList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("courses", courseService.displayAllCourses());
        model.addAttribute("roles", roleService.getRoles());
        return "editUsers";
    }

    @PostMapping("/{id}")
    public String submitUser(@PathVariable Long id, User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("courses", courseService.displayAllCourses());
        model.addAttribute("roles", roleService.getRoles());
        return "registrationForm";
    }

    @PostMapping("/confirm_registration")
    public String submitUserFromForm(User user) {
        userService.saveUser(user);
        return "registrationSuccessful";
    }


}
