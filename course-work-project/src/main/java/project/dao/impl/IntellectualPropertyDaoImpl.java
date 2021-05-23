package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.dao.IntellectualPropertyDao;
import project.model.IntellectualProperty;


@Repository
@RequiredArgsConstructor
@Primary
public class IntellectualPropertyDaoImpl implements IntellectualPropertyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public IntellectualProperty addProperty(IntellectualProperty intellectualProperty) {
        return entityManager.merge(intellectualProperty);
    }

    @Override
    public List<IntellectualProperty> getAll() {
        return (List<IntellectualProperty>) entityManager.createQuery("SELECT ip FROM intellectual_property ip")
            .getResultList();
    }
}
