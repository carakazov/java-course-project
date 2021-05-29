package project.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private PersonalInfoDto personalInfo;
    private byte[] portfolio;
    private String login;
    private boolean isEstablished = false;
    @NotBlank
    private String description;
}
