package project.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddIntellectualPropertyDto {
    private UserDto author;
    @NotNull
    @Valid
    private IntellectualPropertyDto intellectualPropertyDto;
}
