package project.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.dto.RegistrationDto;
import project.model.User;
import project.service.RegistrationService;
import project.support.mapper.UserMapper;

@Data
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserDao userDao;
    private final UserMapper userMapper;

    @Autowired
    public RegistrationServiceImpl(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User addNewUser(RegistrationDto registrationDto) {
        User user = userMapper.fromRegistrationDto(registrationDto);
        return userDao.create(user);
    }
}
