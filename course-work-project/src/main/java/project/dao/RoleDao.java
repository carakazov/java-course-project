package project.dao;

import java.util.List;

import project.model.Role;
import project.model.RoleEnum;

public interface RoleDao {
    Role getByTitle(RoleEnum title);

    List<Role> read();
}
