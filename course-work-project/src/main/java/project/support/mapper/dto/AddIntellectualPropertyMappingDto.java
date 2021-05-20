package project.support.mapper.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.dto.IntellectualPropertyDto;
import project.model.Genre;
import project.model.User;

@Data
@AllArgsConstructor
public class AddIntellectualPropertyMappingDto {
    private IntellectualPropertyDto property;
    private User owner;
    private List<User> authors;
    private List<Genre> genres;
}
