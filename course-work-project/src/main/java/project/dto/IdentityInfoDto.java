package project.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import project.support.validation.annotations.UniqueLogin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class IdentityInfoDto {
    @NotNull(message = "It is required field")
    @Length(min = 5, max = 15, message = "Login should be more than 5 symbols and less than 15")
    @UniqueLogin
    private String login;
    @NotNull
    @Length(min = 5, max = 15, message = "Password should be more than 5 symbols and less than 15")
    private String password;

}
