package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import project.dao.ProfessionDao;
import project.model.Profession;

@Data
public class ProfessionDaoImpl implements ProfessionDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Profession> getAll() {
        return entityManager.createQuery("SELECT item FROM professions item").getResultList();
    }
}
