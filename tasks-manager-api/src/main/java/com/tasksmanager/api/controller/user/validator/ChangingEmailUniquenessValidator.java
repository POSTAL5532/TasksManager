package com.tasksmanager.api.controller.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.service.model.user.User;
import com.tasksmanager.api.security.UserDetailsServiceImpl;
import com.tasksmanager.service.service.UserService;

/**
 * Changing current user email uniqueness validator.
 *
 * @author SIE
 */
public class ChangingEmailUniquenessValidator implements ConstraintValidator<ChangingEmailUniqueness, String> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext cxt) {
        User current = this.userService.getById(this.userDetailsService.getCurrentAuthenticatedUserId());
        return current.getEmail().equals(email) || !userService.existByEmail(email);
    }
}
