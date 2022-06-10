package pl.sda.coursesproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.coursesproject.domain.block.BlockService;
import pl.sda.coursesproject.domain.course.Course;
import pl.sda.coursesproject.domain.course.CourseService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final BlockService blockService;

    public CourseController(CourseService courseService, BlockService blockService) {
        this.courseService = courseService;
        this.blockService = blockService;
    }

    @GetMapping
    public String courseList(Model model) {
        List<Course> allCourses = courseService.displayAllCourses();
        model.addAttribute("courses", allCourses);
        return "courseList";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        courseService.removeCourse(id);
        return "redirect:/courses";
    }


    @GetMapping("/add")
    public String addCourse (Model model) {
        model.addAttribute("course", new Course());
        return "courseRegistrationForm";
    }

    @PostMapping("/confirm_addition")
    public String submitCourseFromForm(Course course) {
        courseService.saveCourse(course);
        return "additionSuccessful";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getById(id));
        model.addAttribute("block", blockService.displayAllBlocks());
        return "editCourses";
    }

    @PostMapping("/{id}")
    public String submitCourse (@PathVariable Long id, Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }



}
