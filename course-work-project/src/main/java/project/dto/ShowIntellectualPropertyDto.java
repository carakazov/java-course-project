package project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowIntellectualPropertyDto {
    private Long propertyId;
    private IntellectualPropertyDto property;
    private List<UserDto> authors;
    private UserDto owner;
    private double rating;
}
