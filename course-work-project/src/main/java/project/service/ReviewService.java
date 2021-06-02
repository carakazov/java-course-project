package project.service;

import java.util.List;

import project.dto.AddReviewDto;
import project.dto.ShowReviewDetails;
import project.dto.ShowReviewDto;

public interface ReviewService {
    void addReview(AddReviewDto newReview);

    List<ShowReviewDto> getAllReviewsOfComposition(int propertyId);

    ShowReviewDetails getReviewDetails(int id);
}
