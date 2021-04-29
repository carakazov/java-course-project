package project.dto;

//import javax.validation.constraints.Size;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PersonalInfoDto {
    @NonNull
    @Size(min = 2, max = 128)
    private String name;
    @NonNull
    @Size(min = 2, max = 128)
    private String surname;
    @Size(max = 128)
    private String middleName;
    @NonNull
    private String email;
}
