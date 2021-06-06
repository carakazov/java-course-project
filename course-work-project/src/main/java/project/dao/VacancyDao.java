package project.dao;

import java.util.List;

import project.model.Profession;
import project.model.Vacancy;

public interface VacancyDao {
    void add(Vacancy vacancy);

    List<Vacancy> getAllOfProfession(Profession profession);

    Vacancy findById(int id);
}
