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
    public List<Role> read() {
        return entityManager.createQuery("SELECT role FROM roles role").getResultList();
    }
}
