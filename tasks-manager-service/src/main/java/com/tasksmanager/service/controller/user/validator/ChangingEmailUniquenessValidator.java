package com.tasksmanager.service.controller.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.service.UserService;

/**
 * Changing current user email uniqueness validator.
 *
 * @author SIE
 */
public class ChangingEmailUniquenessValidator implements ConstraintValidator<ChangingEmailUniqueness, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        User current = this.userService.getCurrentAuthenticatedUser();

        return current.getEmail().equals(email) || !userService.existByEmail(email);
    }
}
