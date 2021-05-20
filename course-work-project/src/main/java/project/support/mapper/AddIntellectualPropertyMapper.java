package project.support.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.model.IntellectualProperty;
import project.support.mapper.dto.AddIntellectualPropertyMappingDto;

@Mapper(config = MapperConfig.class)
public interface AddIntellectualPropertyMapper {

    @Mapping(target = "title", source = "property.attributes.title")
    @Mapping(target = "price", source = "property.attributes.price")
    @Mapping(target = "contentType", source = "property.attributes.contentType")
    @Mapping(target = "accessType", source = "property.attributes.accessType")
    @Mapping(target = "content", source = "property.content")
    IntellectualProperty fromDto(AddIntellectualPropertyMappingDto source);
}
