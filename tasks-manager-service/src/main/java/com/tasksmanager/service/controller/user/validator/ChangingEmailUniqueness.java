package com.tasksmanager.service.controller.user.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tasksmanager.service.controller.auth.validator.EmailUniquenessValidator;

/**
 * Email current user uniqueness validation.
 *
 * @author SIE
 */
@Documented
@Constraint(validatedBy = EmailUniquenessValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChangingEmailUniqueness {

    String message() default "Non unique field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
