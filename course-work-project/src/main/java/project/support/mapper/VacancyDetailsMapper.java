package project.support.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.ShowVacancyDetailsDto;
import project.model.Vacancy;

@Mapper(config = MapperConfig.class, uses = {VacancyMapper.class})
public interface VacancyDetailsMapper {
    @Mapping(target = "item", source = "source")
    @Mapping(target = "description", source = "description")
    ShowVacancyDetailsDto toDto(Vacancy source);

    List<ShowVacancyDetailsDto> toDto(List<Vacancy> source);
}
