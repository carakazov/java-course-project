package project.support.validation.validators;

import java.math.BigDecimal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import project.dto.IntellectualPropertyAttributesDto;
import project.model.AccessTypeEnum;
import project.support.validation.annotations.PriceValidation;

public class PriceValidationValidator implements
    ConstraintValidator<PriceValidation, IntellectualPropertyAttributesDto> {
    @Override
    public void initialize(PriceValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(
        IntellectualPropertyAttributesDto intellectualPropertyAttributesDto,
        ConstraintValidatorContext constraintValidatorContext
    ) {
        if(intellectualPropertyAttributesDto.getAccessType().equals(AccessTypeEnum.free)) {
            return intellectualPropertyAttributesDto.getPrice().equals(BigDecimal.ZERO);
        } else {
            return !intellectualPropertyAttributesDto.getPrice().equals(BigDecimal.ZERO);
        }
    }
}
