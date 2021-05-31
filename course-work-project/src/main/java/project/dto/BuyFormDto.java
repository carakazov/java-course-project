package project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BuyFormDto {
    private int propertyId;
    private String login;
    private double price;
}
