package project.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.BuyRequestDao;
import project.dto.BuyRequestDto;
import project.model.BuyRequest;
import project.model.IntellectualProperty;
import project.model.User;
import project.service.BuyRequestService;
import project.service.PropertyService;
import project.service.UserService;

@Data
@RequiredArgsConstructor
public class BuyRequestServiceImpl implements BuyRequestService {
    private final BuyRequestDao buyRequestDao;
    private final UserService userService;
    private final PropertyService propertyService;

    @Override
    @Transactional
    public void addRequest(BuyRequestDto requestDto) {
        IntellectualProperty property = propertyService.getById(requestDto.getPropertyId());
        User buyer = userService.getUserByLogin(requestDto.getSender().getLogin());
        User seller = property.getOwner();
        BuyRequest buyRequest = new BuyRequest()
            .setBuyer(buyer)
            .setSeller(seller)
            .setSendingDate(requestDto.getSendingDate())
            .setProperty(property);
        buyRequestDao.addRequest(buyRequest);
    }
}
