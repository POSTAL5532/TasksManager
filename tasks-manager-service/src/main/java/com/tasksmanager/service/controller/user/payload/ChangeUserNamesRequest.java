package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.NotBlank;

/**
 * Change user names request.
 *
 * @author SIE
 */
public class ChangeUserNamesRequest {

    @NotBlank(message = "First name must be specified")
    private String firstName;

    @NotBlank(message = "Last name must be specified")
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
