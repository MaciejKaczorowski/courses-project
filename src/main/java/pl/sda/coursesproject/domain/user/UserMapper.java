package pl.sda.coursesproject.domain.user;


import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);


}
