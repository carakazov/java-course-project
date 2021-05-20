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

@Data
public class IntellectualPropertyAttributesDto {
    @NotBlank
    private String title;
    @NotEmpty
    private List<GenreTypeEnum> genres;
    @NotNull
    private AccessTypeEnum accessType;
    @NotNull
    private ContentTypeEnum contentType;
    @NotNull
    private BigDecimal price;
}
