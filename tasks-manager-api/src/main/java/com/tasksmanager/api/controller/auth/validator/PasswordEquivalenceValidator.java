package com.tasksmanager.api.controller.auth.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Passwords equivalence validator.
 *
 * @author SIE
 */
public class PasswordEquivalenceValidator implements ConstraintValidator<PasswordEquivalence, Object> {

    private String password;

    private String passwordMatch;

    @Override
    public void initialize(PasswordEquivalence constraintAnnotation) {
        this.password = constraintAnnotation.password();
        this.passwordMatch = constraintAnnotation.passwordMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object password = new BeanWrapperImpl(value).getPropertyValue(this.password);
        Object passwordMatch = new BeanWrapperImpl(value).getPropertyValue(this.passwordMatch);

        boolean isValid = password != null && password.equals(passwordMatch);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode(this.passwordMatch)
                .addConstraintViolation();
        }

        return isValid;
    }
}
