package project.dao;

import java.util.List;

import project.model.IntellectualProperty;
import project.model.Review;

public interface ReviewDao {
    void add(Review review);

    List<Review> getAllReviewsOfComposition(IntellectualProperty property);

    Review getById(int id);
}
