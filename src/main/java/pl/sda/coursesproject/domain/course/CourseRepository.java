package pl.sda.coursesproject.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findCourseByName(String name);

    public Course findCourseById(Long id);
}
