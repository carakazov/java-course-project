package project.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ShowVacancyDtoListItem {
    private String employerLogin;
    private PersonalInfoDto employer;
    private LocalDateTime startDate;
    private BigDecimal salary;
    private int vacancyId;
}
