package project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubscribeDto {
    private int propertyId;
    private String bloggerLogin;
    private String subscriberLogin;
}
