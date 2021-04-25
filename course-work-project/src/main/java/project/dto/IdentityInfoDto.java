package project.dto;

//import javax.validation.constraints.Size;

import lombok.Data;
//import project.support.validation.annotations.UniqueLogin;

@Data
public class IdentityInfoDto {
    //@NonNull
    //@Size(min = 5, max = 128)
    //@UniqueLogin
    private String login;
    // @NonNull
    //@Size(min = 5, max = 128)
    private String password;
}
