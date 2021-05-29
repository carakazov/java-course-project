package project.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class IntellectualPropertyDto {
    @NotNull(message = "It is required field")
    private byte[] content;
    @NotNull
    @Valid
    private IntellectualPropertyAttributesDto attributes;
}
