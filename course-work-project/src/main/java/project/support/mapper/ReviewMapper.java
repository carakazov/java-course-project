package project.support.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.ShowReviewDto;
import project.model.Review;

@Mapper(config = MapperConfig.class)
public interface ReviewMapper {
    @Mapping(target = "author.name", source = "author.firstName")
    @Mapping(target = "author.surname", source = "author.secondName")
    @Mapping(target = "author.middleName", source = "author.middleName")
    @Mapping(target = "authorLogin", source = "author.login")
    @Mapping(target = "score", source = "score")
    @Mapping(target = "reviewId", source = "id")
    ShowReviewDto toDto(Review source);

    List<ShowReviewDto> toDto(List<Review> source);
}
