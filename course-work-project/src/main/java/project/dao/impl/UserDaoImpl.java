package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.dao.AccessBuyerProfileDao;
import project.dao.UserDao;
import project.model.IntellectualProperty;
import project.model.User;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final AccessBuyerProfileDao accessBuyerProfileDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public User create(User item) {
        return entityManager.merge(item);
    }

    @Override
    @Transactional
    public User update(User item) {
        entityManager.createQuery("UPDATE users user SET user.description = :description " +
            "WHERE user.login = :login")
            .setParameter("description", item.getDescription())
            .setParameter("login", item.getLogin())
            .executeUpdate();
        return entityManager.find(User.class, item.getId());
    }

    @Override
    public void addAuthorship(List<IntellectualProperty> property, String login) {
        User user = getByLogin(login);
        user.getCreatedWorks().addAll(property);
        entityManager.merge(user);
        property.forEach(item -> accessBuyerProfileDao.addForeverAccessAccount(user, item));
    }

    @Override
    public List<String> getAllLogins() {
        return entityManager.createQuery("SELECT user.login FROM users user").getResultList();
    }

    @Override
    public User getByLogin(String login) {
        return (User) entityManager.createQuery("SELECT user FROM users user WHERE user.login = :login")
            .setParameter("login", login)
            .getSingleResult();
    }
}
