package project.support.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.ShowReviewDetails;
import project.model.Review;

@Mapper(config = MapperConfig.class)
public interface ReviewDetailsMapper {
    @Mapping(target = "score", source = "score")
    @Mapping(target = "text", source = "text")
    ShowReviewDetails toDto(Review source);
}
