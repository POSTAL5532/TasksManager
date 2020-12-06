package com.tasksmanager.service.controller.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.service.UserService;

/**
 * Correct user password validator.
 *
 * @author SIE
 */
public class CorrectUserPasswordValidator implements ConstraintValidator<CorrectUserPassword, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        User current = this.userService.getCurrentAuthenticatedUser();

        return current.getPassword().equals(password);
    }
}
