package com.tasksmanager.api.controller.auth.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Email uniqueness validation
 *
 * @author SIE
 */
@Documented
@Constraint(validatedBy = EmailUniquenessValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUniqueness {
    String message() default "Non unique field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}