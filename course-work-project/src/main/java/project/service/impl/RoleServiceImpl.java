package project.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.RoleDao;
import project.model.Role;
import project.model.RoleEnum;
import project.service.RoleService;

@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Override
    @Transactional
    public List<RoleEnum> getAllCommonRoles() {
        List<Role> roles = roleDao.read();
        List<RoleEnum> roleTitles = new ArrayList<>();
        roles.forEach(role -> roleTitles.add(role.getTitle()));
        return roleTitles;
    }
}
