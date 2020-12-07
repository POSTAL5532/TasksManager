package com.tasksmanager.service.controller.auth.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tasksmanager.service.controller.auth.validator.EmailUniqueness;
import com.tasksmanager.service.controller.auth.validator.PasswordEquivalence;
import com.tasksmanager.service.utils.ValidationUtils;

/**
 * SignUp DTO
 *
 * @author SIE
 */
@PasswordEquivalence(password = "password", passwordMatch = "rPassword", message = "Passwords is not equivalence")
public class SignUpRequest {

    @NotBlank(message = "Name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Name is incorrect")
    private String firstName;

    @NotBlank(message = "Last name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Last name is incorrect")
    private String lastName;

    @NotBlank(message = "Email must be specified")
    @Email(message = "Email is incorrect")
    @EmailUniqueness(message = "User with this email is already registered")
    private String email;

    @NotBlank(message = "Password must be specified")
    @Pattern(regexp = ValidationUtils.PASSWORD_PATTERN, message = "Password is incorrect")
    private String password;

    @JsonProperty("rPassword")
    @NotBlank(message = "Repeat must be specified")
    @Pattern(regexp = ValidationUtils.PASSWORD_PATTERN, message = "Repeat password is incorrect")
    private String rPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", rPassword='" + rPassword + '\'' +
            '}';
    }
}
