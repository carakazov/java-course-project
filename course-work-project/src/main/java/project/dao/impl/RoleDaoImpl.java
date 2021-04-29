package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDao;
import project.model.Role;
import project.model.RoleEnum;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Role getByTitle(RoleEnum title) {
        return (Role) entityManager.createQuery("SELECT role FROM roles role WHERE role.title = :title")
            .setParameter("title", title)
            .getSingleResult();
    }

    @Override
    public Role create(Role item) {
        return null;
    }

    @Override
    public List<Role> create(List<Role> item) {
        return null;
    }

    @Override
    public Role read(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> read() {
        return entityManager.createQuery("SELECT role FROM roles role").getResultList();
    }

    @Override
    public Role update(Role item) {
        return null;
    }

    @Override
    public List<Role> update(List<Role> item) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Role item) {

    }
}
