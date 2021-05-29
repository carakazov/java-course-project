package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.dto.UserDto;
import project.model.Portfolio;
import project.model.User;
import project.service.PortfolioService;
import project.service.UserService;
import project.support.mapper.UserMapper;
import project.support.mapper.dto.UserMappingDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final PortfolioService portfolioService;

    @Override
    public User getUserByLogin(String login) {
        User user = userDao.getByLogin(login);
        return userDao.getByLogin(login);
    }

    @Override
    public UserDto getUserDto(String login) {
        User user = userDao.getByLogin(login);
        Portfolio portfolio = portfolioService.getByUser(user);
        return userMapper.fromUser(
            new UserMappingDto(
                user,
                portfolio
            )
        );
    }

    @Override
    public UserDto addUserDescription(String login, String description) {
        User user = userDao.getByLogin(login);
        user.setDescription(description);
        return userMapper.fromUser(
            new UserMappingDto(
                userDao.update(user),
                portfolioService.getByUser(user)
            )
        );
    }
}
