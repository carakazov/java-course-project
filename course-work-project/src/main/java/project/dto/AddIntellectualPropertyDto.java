package project.dto;

import javax.validation.Valid;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddIntellectualPropertyDto {
    private UserDto author;
    private MultipartFile file;
    @Valid
    private IntellectualPropertyDto intellectualPropertyDto;
}
