package project.dto;

import javax.validation.constraints.NotBlank;
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
    @NotNull
    @NotBlank
    @Length(min = 5, max = 15)
    @UniqueLogin
    private String login;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 15)
    private String password;

}
