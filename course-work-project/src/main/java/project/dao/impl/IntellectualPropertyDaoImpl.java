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

    @Override
    public List<IntellectualProperty> getAllUnapproved() {
        return (List<IntellectualProperty>) entityManager.createQuery("SELECT ip FROM intellectual_property ip " +
            "WHERE ip.approved = false").getResultList();
    }

    @Override
    @Transactional
    public void approve(int id) {
        IntellectualProperty property = (IntellectualProperty) entityManager.createQuery("SELECT ip " +
            "FROM intellectual_property ip WHERE ip.id = :id")
            .setParameter("id", id)
            .getSingleResult();
        property.setApproved(true);
        entityManager.merge(property);
    }
}
