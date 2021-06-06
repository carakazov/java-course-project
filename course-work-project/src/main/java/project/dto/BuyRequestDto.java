package project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyRequestDto {
    private String sender;
    private int propertyId;
    private LocalDateTime sendingDate;
}
