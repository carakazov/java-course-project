package project.support.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import project.support.validation.validators.PriceValidationValidator;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriceValidationValidator.class)
public @interface PriceValidation {
    String message() default "Access type and price don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
