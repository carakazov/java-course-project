package project.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ProfessionDao;
import project.dao.UserDao;
import project.dao.VacancyDao;
import project.dto.AddVacancyDto;
import project.dto.ShowVacancyDetailsDto;
import project.dto.ShowVacancyDtoListItem;
import project.model.Profession;
import project.model.ProfessionEnum;
import project.model.User;
import project.model.Vacancy;
import project.service.VacancyService;
import project.support.mapper.VacancyDetailsMapper;
import project.support.mapper.VacancyMapper;

@Data
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;
    private final ProfessionDao professionDao;
    private final UserDao userDao;
    private final VacancyMapper vacancyMapper;
    private final VacancyDetailsMapper vacancyDetailsMapper;

    @Override
    @Transactional
    public void addVacancy(AddVacancyDto addVacancyDto) {
        User employer = userDao.getByLogin(addVacancyDto.getEmployerLogin());
        Profession profession = professionDao.getByTitle(addVacancyDto.getProfession());
        Vacancy vacancy = new Vacancy()
            .setDescription(addVacancyDto.getDescription())
            .setSalary(addVacancyDto.getSalary())
            .setEmployer(employer)
            .setProfession(profession)
            .setWorkExperience(addVacancyDto.getExperience())
            .setOpenDate(LocalDateTime.now());
        vacancyDao.add(vacancy);
    }

    @Override
    public List<ShowVacancyDtoListItem> getAllOfProfession(ProfessionEnum profession) {
        Profession profObj = professionDao.getByTitle(profession);
        return vacancyMapper.fromDto(vacancyDao.getAllOfProfession(profObj));
    }

    @Override
    public ShowVacancyDetailsDto getDetails(int vacancyId) {
        return vacancyDetailsMapper.toDto(vacancyDao.findById(vacancyId));
    }
}
