package com.tasksmanager.service.controller.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.service.UserService;
import com.tasksmanager.service.utils.AuthUtils;

/**
 * Changing current user email uniqueness validator.
 *
 * @author SIE
 */
public class ChangingEmailUniquenessValidator implements ConstraintValidator<ChangingEmailUniqueness, String> {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthUtils authUtils;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        User current = this.authUtils.getCurrentAuthenticatedUser();

        return current.getEmail().equals(email) || !userService.existByEmail(email);
    }
}
