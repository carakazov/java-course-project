package project.dao;

import project.model.Role;
import project.model.RoleEnum;

public interface RoleDao extends IDao<Role> {
    Role getByTitle(RoleEnum title);
}
