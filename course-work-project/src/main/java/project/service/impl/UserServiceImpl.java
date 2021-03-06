package project.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
                userDao.updateDescription(user),
                portfolioService.getByUser(user)
            )
        );
    }

    @Override
    @Transactional
    public void subscribe(String bloggerLogin, String subscriberLogin) {
        User blogger = userDao.getByLogin(bloggerLogin);
        User subscriber = userDao.getByLogin(subscriberLogin);
        subscriber.getBloggers().add(blogger);
        userDao.update(subscriber);
    }

    @Override
    public List<UserDto> getAllLookingForWork() {
        List<User> user = userDao.getAllLookingForWork();
        List<UserMappingDto> userMappingDtos = new ArrayList<>();
        user.forEach(item -> userMappingDtos.add(new UserMappingDto(
            item,
            portfolioService.getByUser(item)
        )));
        return userMapper.fromUser(userMappingDtos);
    }
}
