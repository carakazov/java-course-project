package project.service;

import project.dto.UserDto;

public interface UserService {
    UserDto getUserDto(String login);
}
