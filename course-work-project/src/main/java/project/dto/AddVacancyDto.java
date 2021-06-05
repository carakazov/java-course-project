package project.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;

import lombok.Data;
import project.model.ProfessionEnum;

@Data
public class AddVacancyDto {
    private String employerLogin;
    private String description;
    @Min(1)
    private BigDecimal salary;
    private ProfessionEnum profession;
    private int experience = 0;
}
