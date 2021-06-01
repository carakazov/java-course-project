package project.support.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.dto.ShowBuyRequestDto;
import project.model.BuyRequest;

@Mapper(config = MapperConfig.class)
public interface BuyRequestMapper {
    @Mapping(target = "requestId", source = "id")
    @Mapping(target = "senderLogin", source = "buyer.login")
    @Mapping(target = "senderInfo.name", source = "buyer.firstName")
    @Mapping(target = "senderInfo.surname", source = "buyer.secondName")
    @Mapping(target = "senderInfo.middleName", source = "buyer.middleName")
    @Mapping(target = "senderInfo.email", source = "buyer.email")
    @Mapping(target = "propertyTitle", source = "property.title")
    @Mapping(target = "propertyId", source = "property.id")
    ShowBuyRequestDto toDto(BuyRequest source);

    List<ShowBuyRequestDto> toDto(List<BuyRequest> source);
}
