package pl.sda.coursesproject.domain.course;

import org.springframework.stereotype.Service;
import pl.sda.coursesproject.domain.block.Block;
import pl.sda.coursesproject.domain.block.BlockRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final BlockRepository blockRepository;

    public CourseService(CourseRepository courseRepository, BlockRepository blockRepository) {
        this.courseRepository = courseRepository;
        this.blockRepository = blockRepository;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseByName (String name) {
        return courseRepository.findCourseByName(name);
    }

    public void removeCourse(Long id) {
        courseRepository.delete(courseRepository.getById(id));
    }

    public List<Course> displayAllCourses () {
        return courseRepository.findAll();

    }

    @Transactional
    public Course addBlockToCourse (Long courseId, Long blockId) {
        Course course = courseRepository.getById(courseId);
        Block block = blockRepository.getById(blockId);
        List<Block> blocks = course.getBlocks();
        blocks.add(block);
        course.setBlocks(blocks);
        return courseRepository.save(course);
    }

    public Course getById(Long id) {
        return courseRepository.getById(id);
    }
}
