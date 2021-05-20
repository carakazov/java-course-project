package project.support.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.model.Portfolio;
import project.model.User;

@Data
@AllArgsConstructor
public class UserMappingDto {
    private User user;
    private Portfolio portfolio;
}
