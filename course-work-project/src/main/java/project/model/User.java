package project.model;

import java.util.List;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends PrimaryKeyEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "middle_name")
    private String middleName;
    private String email;
    private String login;
    private String password;
    @Column(name = "looking_for_work")
    private Boolean isLookingForWork;
    private String description;
    @OneToMany(mappedBy = "owner")
    private List<IntellectualProperty> ownedProperty;
    @ManyToMany
    @JoinTable(
        name = "intellectual_property_author",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "intellectual_property_id")
    )
    private List<IntellectualProperty> createdWorks;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<AccessBuyerProfile> profiles;
}
