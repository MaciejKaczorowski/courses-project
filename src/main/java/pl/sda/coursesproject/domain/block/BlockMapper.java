package pl.sda.coursesproject.domain.block;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlockMapper {

    BlockMapper INSTANCE = Mappers.getMapper(BlockMapper.class);

    BlockDto toDto(Block block);

    Block toEntity(BlockDto blockDto);
}
