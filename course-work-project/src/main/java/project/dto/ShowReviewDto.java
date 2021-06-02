package project.dto;

import lombok.Data;

@Data
public class ShowReviewDto {
    private PersonalInfoDto author;
    private String authorLogin;
    private double score;
    private int reviewId;
}
