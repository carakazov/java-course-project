package project.service;

import java.util.List;

import project.dto.UserDto;
import project.model.User;

public interface UserService {
    User getUserByLogin(String login);

    UserDto getUserDto(String login);

    UserDto addUserDescription(String login, String description);

    void subscribe(String bloggerLogin, String subscriberLogin);

    List<UserDto> getAllLookingForWork();
}
