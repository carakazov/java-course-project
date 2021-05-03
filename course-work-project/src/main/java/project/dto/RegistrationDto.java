package project.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RegistrationDto {
    @NotNull
    @Valid
    private IdentityInfoDto identityInfoDto;
    @NotNull
    @Valid
    private PersonalInfoDto personalInfoDto;
    @NotEmpty(message = "You should choose at least one role.")
    private List<String> roles;
    private boolean lookingForWork;
}
