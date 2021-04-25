package project.model;

import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "users")
@Data
public class User extends PrimaryKeyEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "middle_name")
    private String middle_name;
    private String email;
    private String  phone;
    private String login;
    private String password;
    @Column(name = "looking_for_work")
    private Boolean isLookingForWork;

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
