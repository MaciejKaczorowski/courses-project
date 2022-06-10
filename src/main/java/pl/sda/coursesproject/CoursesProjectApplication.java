package pl.sda.coursesproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.coursesproject.domain.block.Block;
import pl.sda.coursesproject.domain.block.BlockRepository;
import pl.sda.coursesproject.domain.block.BlockService;
import pl.sda.coursesproject.domain.course.CourseService;
import pl.sda.coursesproject.domain.role.RoleRepository;
import pl.sda.coursesproject.domain.role.RoleService;
import pl.sda.coursesproject.domain.user.UserRepository;
import pl.sda.coursesproject.domain.user.UserService;

import static java.lang.Long.valueOf;

@SpringBootApplication
public class CoursesProjectApplication implements CommandLineRunner {

	private final UserService userService;

	private final UserRepository userRepository;

	private final CourseService courseService;

	private final RoleService roleService;

	private final RoleRepository roleRepository;

	private final BlockService blockService;

	private final BlockRepository blockRepository;

	public CoursesProjectApplication(UserService userService, UserRepository userRepository, CourseService courseService, RoleService roleService, RoleRepository roleRepository, BlockService blockService, BlockRepository blockRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
		this.courseService = courseService;
		this.roleService = roleService;
		this.roleRepository = roleRepository;
		this.blockService = blockService;


		this.blockRepository = blockRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(CoursesProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {




//		User user = new User("jandzban", "jandzban", "Jan", "Dzban",true);
//
//		System.out.println(userService.addUser(user));
//
//		Course course = new Course("English");
//
//		System.out.println(courseService.addCourse(course));


//

//		Long courseId = courseService.getCourseByName("English").getId();
//		Long userId = userService.getByLogin("jandzban").getId();
//
//		userService.addCourseToUser(courseId, userId);

//		System.out.println(userRepository.getUsersWithCourses("Dzban"));

//		Block block = new Block("Speaking");
//		Block block2 = new Block("Writing");
//
//		blockService.addBlock(block);
//		blockService.addBlock(block2);





	}



}
