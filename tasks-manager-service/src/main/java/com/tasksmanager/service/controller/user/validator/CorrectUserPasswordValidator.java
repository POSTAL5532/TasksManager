package com.tasksmanager.service.controller.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.security.UserDetailsServiceImpl;
import com.tasksmanager.service.service.UserService;

/**
 * Correct user password validator.
 *
 * @author SIE
 */
public class CorrectUserPasswordValidator implements ConstraintValidator<CorrectUserPassword, String> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        User current = this.userService.getById(this.userDetailsService.getCurrentAuthenticatedUserId());
        return current.getPassword().equals(password);
    }
}
