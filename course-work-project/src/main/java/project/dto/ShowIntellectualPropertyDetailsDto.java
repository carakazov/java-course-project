package project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ShowIntellectualPropertyDetailsDto {
    private boolean available;
    private boolean forever;
    private boolean watched;
    private ShowIntellectualPropertyDto property;
}
