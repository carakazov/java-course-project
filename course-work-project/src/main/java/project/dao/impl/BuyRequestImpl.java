package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.BuyRequestDao;
import project.model.BuyRequest;

@Data
@RequiredArgsConstructor
public class BuyRequestImpl implements BuyRequestDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRequest(BuyRequest request) {
        entityManager.merge(request);
    }
}
