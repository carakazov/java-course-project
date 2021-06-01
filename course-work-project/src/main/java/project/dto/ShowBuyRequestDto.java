package project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShowBuyRequestDto {
    private int requestId;
    private String senderLogin;
    private PersonalInfoDto senderInfo;
    private String propertyTitle;
    private int propertyId;
}
