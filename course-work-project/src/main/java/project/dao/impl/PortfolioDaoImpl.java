package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.PortfolioDao;
import project.model.Portfolio;
import project.model.User;

@Service
public class PortfolioDaoImpl implements PortfolioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Portfolio findPortfolioOfUser(User user) {
        try {
            return (Portfolio) entityManager.createQuery("SELECT portfolio FROM " +
                "portfolios portfolio WHERE portfolio.user = :user")
                .setParameter("user", user)
                .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
}
