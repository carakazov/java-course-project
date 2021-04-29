package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User create(User item) {
        return entityManager.merge(item);
    }

    @Override
    public List<User> create(List<User> item) {
        return null;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public List<User> update(List<User> item) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void delete(User item) {
    }

    @Override
    public List<String> getAllLogins() {
        return entityManager.createQuery("SELECT user.login FROM users user").getResultList();
    }
}
