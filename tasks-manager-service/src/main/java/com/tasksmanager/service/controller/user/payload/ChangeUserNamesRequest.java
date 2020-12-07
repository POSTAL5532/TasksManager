package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.tasksmanager.service.utils.ValidationUtils;

/**
 * Change user names request.
 *
 * @author SIE
 */
public class ChangeUserNamesRequest {

    @NotBlank(message = "First name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Name is incorrect")
    private String firstName;

    @NotBlank(message = "Last name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Last name is incorrect")
    private String lastName;

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

    @Override
    public String toString() {
        return "ChangeUserNamesRequest{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
