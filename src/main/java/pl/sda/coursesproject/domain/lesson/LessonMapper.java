package pl.sda.coursesproject.domain.lesson;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    LessonDto toDto (Lesson lesson);

    Lesson toEntity (LessonDto lessonDto);
}
