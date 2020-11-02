package com.tasksmanager.service.controller.auth.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Has user by email validation
 *
 * @author SIE
 */
@Documented
@Constraint(validatedBy = UserExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExist {
    String message() default "User is not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
