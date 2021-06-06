package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import project.dao.VacancyDao;
import project.model.Profession;
import project.model.Vacancy;

@Data
public class VacancyDaoImpl implements VacancyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Vacancy vacancy) {
        entityManager.merge(vacancy);
    }

    @Override
    public List<Vacancy> getAllOfProfession(Profession profession) {
        return entityManager.createQuery("SELECT vacancy FROM vacancies vacancy WHERE vacancy.profession = :profession")
            .setParameter("profession", profession).getResultList();
    }

    @Override
    public Vacancy findById(int id) {
        return (Vacancy) entityManager.createQuery("SELECT vacancy FROM vacancies vacancy WHERE vacancy.id = :id")
            .setParameter("id", id)
            .getSingleResult();
    }
}

