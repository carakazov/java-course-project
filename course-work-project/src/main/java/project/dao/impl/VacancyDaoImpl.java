package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import project.dao.VacancyDao;
import project.model.Vacancy;

@Data
public class VacancyDaoImpl implements VacancyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Vacancy vacancy) {
        entityManager.merge(vacancy);
    }
}

