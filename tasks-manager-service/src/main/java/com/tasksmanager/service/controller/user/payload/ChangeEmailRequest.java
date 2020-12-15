package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.tasksmanager.service.controller.user.validator.ChangingEmailUniqueness;

import lombok.Getter;
import lombok.ToString;

/**
 * Change user email request.
 *
 * @author SIE
 */
@Getter
@ToString
public class ChangeEmailRequest {

    @NotBlank(message = "Email must be specified")
    @Email(message = "Email is incorrect")
    @ChangingEmailUniqueness(message = "User with this email is already registered")
    private String email;
}
