package project.dao;

import java.util.List;

import project.model.IntellectualProperty;
import project.model.User;

public interface UserDao {
    List<String> getAllLogins();

    User getByLogin(String login);

    User create(User item);

    User updateDescription(User item);

    void addAuthorship(List<IntellectualProperty> property, String login);

    void update(User user);

    List<User> getAllLookingForWork();
}
