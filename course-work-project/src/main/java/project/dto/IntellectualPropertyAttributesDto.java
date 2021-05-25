package project.dto;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import project.model.AccessTypeEnum;
import project.model.ContentTypeEnum;
import project.model.GenreTypeEnum;
import project.support.validation.annotations.PriceValidation;

@Data
@PriceValidation
public class IntellectualPropertyAttributesDto {
    @NotBlank(message = "It is required field")
    private String title;
    @NotEmpty(message = "It is required field")
    private List<GenreTypeEnum> genres;
    @NotNull(message = "It is required field")
    private AccessTypeEnum accessType;
    @NotNull(message = "It is required field")
    private ContentTypeEnum contentType;
    private BigDecimal price = BigDecimal.ZERO;
}
