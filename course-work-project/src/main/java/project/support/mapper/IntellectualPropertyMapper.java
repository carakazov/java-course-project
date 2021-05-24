package project.support.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import project.dto.ShowIntellectualPropertyDto;
import project.model.Genre;
import project.model.GenreTypeEnum;
import project.model.IntellectualProperty;
import project.support.mapper.dto.AddIntellectualPropertyMappingDto;

@Mapper(config = MapperConfig.class, uses = {UserMapper.class})
public interface IntellectualPropertyMapper {

    @Mapping(target = "title", source = "property.attributes.title")
    @Mapping(target = "price", source = "property.attributes.price")
    @Mapping(target = "contentType", source = "property.attributes.contentType")
    @Mapping(target = "accessType", source = "property.attributes.accessType")
    @Mapping(target = "content", source = "property.content")
    IntellectualProperty fromAddDto(AddIntellectualPropertyMappingDto source);

    @Mapping(target = "propertyId", source = "source.id")
    @Mapping(target = "property.content", source = "content")
    @Mapping(target = "property.attributes.title", source = "title")
    @Mapping(target = "property.attributes.genres", source = "genres", qualifiedByName = "genreEnumMapper")
    @Mapping(target = "property.attributes.accessType", source = "accessType")
    @Mapping(target = "property.attributes.contentType", source = "contentType")
    ShowIntellectualPropertyDto toShowDto(IntellectualProperty source);

    List<ShowIntellectualPropertyDto> toShowDto(List<IntellectualProperty> source);

    @Named("genreEnumMapper")
    default List<GenreTypeEnum> mapGenreEnum(List<Genre> value) {
        return value.stream()
            .map(Genre::getTitle)
            .collect(Collectors.toList());
    }
}
