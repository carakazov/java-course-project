package project.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDao;
import project.dao.UserDao;
import project.dto.RegistrationDto;
import project.model.Role;
import project.model.RoleEnum;
import project.model.User;
import project.service.RegistrationService;
import project.support.mapper.UserMapper;

@Data
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserDao userDao;
    private final UserMapper userMapper;
    private final RoleDao roleDao;


    @Override
    @Transactional
    public User addNewUser(RegistrationDto registrationDto) {
        User user = userMapper.fromRegistrationDto(registrationDto);
        List<Role> userRoles = new ArrayList<>();
        registrationDto.getRoles().forEach(role ->
            userRoles.add(roleDao.getByTitle(RoleEnum.valueOf(role))));
        User newUser = userDao.create(user);
        newUser.setRoles(userRoles);
        return newUser;
    }
}
