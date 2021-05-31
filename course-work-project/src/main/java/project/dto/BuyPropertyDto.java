package project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BuyPropertyDto {
    private String login;
    private int propertyId;
    private boolean forever;
}
