package project.dto;

//import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PersonalInfoDto {
    //@NonNull
    //@Size(min = 2, max = 128)
    private String name;
    // @NonNull
    //@Size(min = 2, max = 128)
    private String surname;
    //  @Size(max = 128)
    private String middleName;
    // @NonNull
    private String email;
}
