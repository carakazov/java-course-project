package project.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PersonalInfoDto {
    @NotNull(message = "It is required field")
    @Length(min = 2, max = 128, message = "Name should be greater than 2 symbols and less than 128")
    private String name;
    @NotNull(message = "It is required field")
    @Length(min = 2, max = 128, message = "Surname should be greater than 2 symbols and less than 128")
    private String surname;
    @Length(max = 128, message = "Middle name should be greater less than 128 symbols")
    private String middleName;
    @NotNull(message = "It is required field")
    private String email;
}
