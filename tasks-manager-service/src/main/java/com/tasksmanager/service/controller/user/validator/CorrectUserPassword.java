package com.tasksmanager.service.controller.user.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Correct user password validator.
 *
 * @author SIE
 */
@Documented
@Constraint(validatedBy = CorrectUserPasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectUserPassword {

    String message() default "Non correct password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
