package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.dto.UserDto;
import project.model.User;
import project.service.UserService;
import project.support.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;

    @Override
    public UserDto getUserDto(String login) {
        User user = userDao.getByLogin(login);
        return userMapper.fromUser(user);
    }
}
