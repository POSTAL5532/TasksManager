package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.tasksmanager.service.controller.user.validator.ChangingEmailUniqueness;

/**
 * Change user email request.
 *
 * @author SIE
 */
public class ChangeEmailRequest {

    @NotBlank
    @Email(message = "Email is incorrect")
    @ChangingEmailUniqueness(message = "User with this email is already registered")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ChangeEmailRequest{" +
            "email='" + email + '\'' +
            '}';
    }
}
