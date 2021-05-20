package project.dto;

import javax.validation.Valid;

import lombok.Data;

@Data
public class AddIntellectualPropertyDto {
    private UserDto author;
    @Valid
    private IntellectualPropertyDto intellectualPropertyDto;
}
