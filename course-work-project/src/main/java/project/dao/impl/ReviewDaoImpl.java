package project.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.ReviewDao;
import project.model.IntellectualProperty;
import project.model.Review;

@Data
@RequiredArgsConstructor
public class ReviewDaoImpl implements ReviewDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Review review) {
        entityManager.merge(review);
    }

    @Override
    public List<Review> getAllReviewsOfComposition(IntellectualProperty property) {
        return entityManager.createQuery(
            "SELECT review FROM reviews review WHERE review.intellectualProperty = :ip"
        ).setParameter("ip", property).getResultList();
    }

    @Override
    public Review getById(int id) {
        return (Review) entityManager.createQuery("SELECT review FROM reviews review WHERE review.id = :id")
            .setParameter("id", id).getSingleResult();
    }
}
