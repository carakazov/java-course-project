package project.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Role extends PrimaryKeyEntity{
    @Enumerated(EnumType.STRING)
    private RoleEnum title;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
