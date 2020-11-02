package com.tasksmanager.service.controller.auth.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.service.service.UserService;

/**
 * Has user by email validator
 *
 * @author SIE
 */
public class UserExistValidator implements ConstraintValidator<UserExist, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        return userService.existByEmail(email);
    }
}
