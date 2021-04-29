package project.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    @NonNull
    private List<String> roles;
    @NonNull
    private boolean lookingForWork;
}
