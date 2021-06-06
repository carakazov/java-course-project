package project.service;

import java.util.List;

import project.dto.AddVacancyDto;
import project.dto.ShowVacancyDetailsDto;
import project.dto.ShowVacancyDtoListItem;
import project.model.ProfessionEnum;

public interface VacancyService {
    void addVacancy(AddVacancyDto addVacancyDto);

    List<ShowVacancyDtoListItem> getAllOfProfession(ProfessionEnum profession);

    ShowVacancyDetailsDto getDetails(int vacancyId);
}
