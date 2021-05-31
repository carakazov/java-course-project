package project.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.AccessBuyerProfileDao;
import project.dto.BuyPropertyDto;
import project.model.IntellectualProperty;
import project.model.User;
import project.service.AccessBuyerProfileService;
import project.service.PropertyService;
import project.service.UserService;

@Data
@RequiredArgsConstructor
public class AccessBuyerProfileServiceImpl implements AccessBuyerProfileService {
    private final UserService userService;
    private final PropertyService propertyService;
    private final AccessBuyerProfileDao accessBuyerProfileDao;

    @Override
    @Transactional
    public void addProfile(BuyPropertyDto buyPropertyDto) {
        User user = userService.getUserByLogin(buyPropertyDto.getLogin());
        IntellectualProperty property = propertyService.getById(buyPropertyDto.getPropertyId());
        if(buyPropertyDto.isForever()) {
            accessBuyerProfileDao.addForeverAccessAccount(user, property);
        } else {
            accessBuyerProfileDao.addTemporalAccessAccount(user, property);
        }
    }

    @Override
    @Transactional
    public void addAccessToAllCompositionsOfBlogger(String bloggerLogin, String subscriberLogin) {
        User user = userService.getUserByLogin(subscriberLogin);
        propertyService.getAllPropertyOfUser(bloggerLogin)
            .forEach(item -> accessBuyerProfileDao.addForeverAccessAccount(user, item));
    }
}
