package com.tasksmanager.service.controller.auth.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Passwords equivalence validation
 *
 * @author SIE
 */
@Constraint(validatedBy = PasswordEquivalenceValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordEquivalence {

    String message() default "Fields not equivalence";

    String password();

    String passwordMatch();

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        PasswordEquivalence[] value();
    }

}
