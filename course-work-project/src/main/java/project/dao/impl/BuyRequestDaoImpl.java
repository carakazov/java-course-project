package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.BuyRequestDao;
import project.model.BuyRequest;
import project.model.IntellectualProperty;
import project.model.User;

@Data
@RequiredArgsConstructor
public class BuyRequestDaoImpl implements BuyRequestDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRequest(BuyRequest request) {
        entityManager.merge(request);
    }

    @Override
    public boolean checkRequest(User buyer, IntellectualProperty property) {
        List<BuyRequest> requests =
            entityManager.createQuery("SELECT item FROM buy_requests item WHERE item.success is null").getResultList();
        return requests.stream().anyMatch(item -> item.getBuyer().equals(buyer) && item.getProperty().equals(property));
    }

    @Override
    public List<BuyRequest> getAllReceivedRequests(User seller) {
        return entityManager.createQuery("SELECT item FROM buy_requests item WHERE " +
            "item.seller = :seller AND item.success is null")
            .setParameter("seller", seller).getResultList();
    }

    @Override
    public void update(BuyRequest request) {
        entityManager.merge(request);
    }

    @Override
    public BuyRequest getById(int id) {
        return (BuyRequest) entityManager.createQuery("SELECT request FROM buy_requests request WHERE request.id = :id")
            .setParameter("id", id).getSingleResult();
    }
}
