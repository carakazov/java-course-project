package project.support.mapper.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.model.IntellectualProperty;

@Data
@AllArgsConstructor
public class ShowIntellectualPropertyMappingDto {
    private IntellectualProperty property;
    private UserMappingDto owner;
    private List<UserMappingDto> authors;
}
