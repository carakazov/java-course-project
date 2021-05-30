package project.dao;

import project.model.IntellectualProperty;
import project.model.User;

public interface AccessBuyerProfileDao {
    void addForeverAccessAccount(User user, IntellectualProperty property);
}
