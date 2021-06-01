package project.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.BuyRequestDao;
import project.dto.BuyRequestDto;
import project.dto.ShowBuyRequestDto;
import project.model.BuyRequest;
import project.model.IntellectualProperty;
import project.model.User;
import project.service.BuyRequestService;
import project.service.PropertyService;
import project.service.UserService;
import project.support.mapper.BuyRequestMapper;

@Data
@RequiredArgsConstructor
public class BuyRequestServiceImpl implements BuyRequestService {
    private final BuyRequestDao buyRequestDao;
    private final UserService userService;
    private final PropertyService propertyService;
    private final BuyRequestMapper buyRequestMapper;

    @Override
    @Transactional
    public void addRequest(BuyRequestDto requestDto) {
        IntellectualProperty property = propertyService.getById(requestDto.getPropertyId());
        User buyer = userService.getUserByLogin(requestDto.getSender());
        User seller = property.getOwner();
        BuyRequest buyRequest = new BuyRequest()
            .setBuyer(buyer)
            .setSeller(seller)
            .setSendingDate(requestDto.getSendingDate())
            .setProperty(property);
        buyRequestDao.addRequest(buyRequest);
    }

    @Override
    @Transactional
    public List<ShowBuyRequestDto> getAllRequests(String sellerLogin) {
        return buyRequestMapper.toDto(buyRequestDao.getAllReceivedRequests(
            userService.getUserByLogin(sellerLogin)
        ));
    }

    @Override
    @Transactional
    public void changeRequestStatus(int requestId, boolean result) {
        BuyRequest buyRequest = buyRequestDao.getById(requestId);
        buyRequest.setSuccess(result);
        buyRequest.setResponseDate(LocalDateTime.now());
        buyRequestDao.update(buyRequest);
    }
}
