package pl.sda.coursesproject.domain.course;

import org.mapstruct.factory.Mappers;

public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDto toDto(Course course);

    Course toEntity(CourseDto courseDto);
}
