package project.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Valid
public class AddReviewDto {
    private int propertyId;
    private String authorLogin;
    @Min(value = 0, message = "Score must be more than zero")
    @Max(value = 10, message = "Score must be less than ten")
    private double score;
    private String text;
}
