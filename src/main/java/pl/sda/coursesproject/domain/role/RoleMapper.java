package pl.sda.coursesproject.domain.role;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toDto (Role role);

    Role toEntity (RoleDto roleDto);

}
