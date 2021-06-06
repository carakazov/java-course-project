package project.service.impl;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.IntellectualPropertyDao;
import project.dao.ReviewDao;
import project.dto.AddReviewDto;
import project.dto.ShowReviewDetails;
import project.dto.ShowReviewDto;
import project.model.IntellectualProperty;
import project.model.Review;
import project.model.User;
import project.service.ReviewService;
import project.service.UserService;
import project.support.mapper.ReviewDetailsMapper;
import project.support.mapper.ReviewMapper;

@Data
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewDao reviewDao;
    private final IntellectualPropertyDao propertyDao;
    private final UserService userService;
    private final ReviewMapper reviewMapper;
    private final ReviewDetailsMapper reviewDetailsMapper;

    @Override
    @Transactional
    public void addReview(AddReviewDto newReview) {
        User author = userService.getUserByLogin(newReview.getAuthorLogin());
        IntellectualProperty property = propertyDao.getById(newReview.getPropertyId());
        Review review = new Review()
            .setAuthor(author)
            .setIntellectualProperty(property)
            .setText(newReview.getText())
            .setScore(newReview.getScore());
        property.setRating(calculateFinalSore(newReview.getScore(), property));
        reviewDao.add(review);
        propertyDao.update(property);
    }

    @Override
    @Transactional
    public List<ShowReviewDto> getAllReviewsOfComposition(int propertyId) {
        return reviewMapper.toDto(reviewDao.getAllReviewsOfComposition(propertyDao.getById(propertyId)));
    }

    @Override
    public ShowReviewDetails getReviewDetails(int id) {
        return reviewDetailsMapper.toDto(reviewDao.getById(id));
    }

    private double calculateFinalSore(double score, IntellectualProperty property) {
        return (property.getRating() * property.getNumberOfScores() + score) / (property.getNumberOfScores() + 1);
    }
}
