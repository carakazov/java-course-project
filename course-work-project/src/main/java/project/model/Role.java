package project.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Role extends PrimaryKeyEntity{
    @Enumerated(EnumType.STRING)
    private RoleEnum title;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
