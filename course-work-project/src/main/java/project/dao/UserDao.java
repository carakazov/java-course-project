package project.dao;

import java.util.List;

import project.model.IntellectualProperty;
import project.model.User;

public interface UserDao {
    List<String> getAllLogins();

    User getByLogin(String login);

    User create(User item);

    User update(User item);

    void addAuthorship(List<IntellectualProperty> property, String login);
}
