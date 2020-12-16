package com.tasksmanager.api.controller.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tasksmanager.service.service.UserService;

/**
 * Email uniqueness validator
 *
 * @author SIE
 */
public class EmailUniquenessValidator implements ConstraintValidator<EmailUniqueness, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return !userService.existByEmail(email);
    }
}

