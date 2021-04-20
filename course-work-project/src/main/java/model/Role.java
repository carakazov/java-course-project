package model;

import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Role extends PrimaryKeyEntity{
    @Enumerated(EnumType.STRING)
    private RoleEnum title;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
