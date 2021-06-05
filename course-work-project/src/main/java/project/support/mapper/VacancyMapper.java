package project.support.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.ShowVacancyDtoListItem;
import project.model.Vacancy;

@Mapper(config = MapperConfig.class)
public interface VacancyMapper {
    @Mapping(target = "employerLogin", source = "employer.login")
    @Mapping(target = "employer.name", source = "employer.firstName")
    @Mapping(target = "employer.surname", source = "employer.secondName")
    @Mapping(target = "employer.middleName", source = "employer.middleName")
    @Mapping(target = "employer.email", source = "employer.email")
    @Mapping(target = "salary", source = "salary")
    @Mapping(target = "startDate", source = "openDate")
    @Mapping(target = "vacancyId", source = "id")
    ShowVacancyDtoListItem fromDto(Vacancy source);

    List<ShowVacancyDtoListItem> fromDto(List<Vacancy> source);
}
