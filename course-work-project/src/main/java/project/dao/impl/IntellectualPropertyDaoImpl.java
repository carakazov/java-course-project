package project.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.dao.AccessBuyerProfileDao;
import project.dao.IntellectualPropertyDao;
import project.dao.UserDao;
import project.model.IntellectualProperty;


@Repository
@RequiredArgsConstructor
@Primary
public class IntellectualPropertyDaoImpl implements IntellectualPropertyDao {
    private final UserDao userDao;
    private final AccessBuyerProfileDao accessBuyerProfileDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addProperty(IntellectualProperty intellectualProperty) {
        intellectualProperty.setUploadDate(LocalDateTime.now());
        IntellectualProperty addedProperty = entityManager.merge(intellectualProperty);
        userDao.addAuthorship(new ArrayList<>(Arrays.asList(addedProperty)), addedProperty.getOwner().getLogin());
        accessBuyerProfileDao.addForeverAccessAccount(addedProperty.getOwner(), addedProperty);
    }

    @Override
    @Transactional
    public List<IntellectualProperty> getAll() {
        List<IntellectualProperty> list = entityManager.createQuery("SELECT ip FROM intellectual_property ip WHERE " +
            "ip.approved = true")
            .getResultList();
        return list.stream()
            .sorted(Comparator.comparing(IntellectualProperty::getUploadDate))
            .collect(Collectors.toList());
    }

    @Override
    public List<IntellectualProperty> getAllUnchecked() {
        return (List<IntellectualProperty>) entityManager.createQuery("SELECT ip FROM intellectual_property ip " +
            "WHERE ip.approved is null ")
            .getResultList();
    }

    @Override
    @Transactional
    public void approve(int id) {
        IntellectualProperty property = findById(id);
        property.setApproved(true);
        entityManager.merge(property);
    }

    @Override
    @Transactional
    public void decline(int id) {
        IntellectualProperty property = findById(id);
        property.setApproved(false);
        entityManager.merge(property);
    }

    @Override
    @Transactional
    public IntellectualProperty getById(int id) {
        return (IntellectualProperty) entityManager.createQuery("SELECT ip FROM intellectual_property ip " +
            "WHERE ip.id =:id")
            .setParameter("id", id)
            .getSingleResult();
    }

    private IntellectualProperty findById(int id) {
        return (IntellectualProperty) entityManager.createQuery("SELECT ip " +
            "FROM intellectual_property ip WHERE ip.id = :id")
            .setParameter("id", id)
            .getSingleResult();
    }

}
