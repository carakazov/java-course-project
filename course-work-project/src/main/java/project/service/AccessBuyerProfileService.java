package project.service;

import project.dto.BuyPropertyDto;

public interface AccessBuyerProfileService {
    void addProfile(BuyPropertyDto buyPropertyDto);

    void addAccessToAllCompositionsOfBlogger(String bloggerLogin, String subscriberLogin);
}
