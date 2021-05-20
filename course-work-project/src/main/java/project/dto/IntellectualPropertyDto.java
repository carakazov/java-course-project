package project.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class IntellectualPropertyDto {
    @NotNull
    private byte[] content;
    @Valid
    private IntellectualPropertyAttributesDto attributes;
}
