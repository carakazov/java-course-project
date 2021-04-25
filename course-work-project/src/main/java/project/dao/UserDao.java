package project.dao;

import java.util.List;

import project.model.User;

public interface UserDao extends IDao<User> {
    List<String> getAllLogins();
}
