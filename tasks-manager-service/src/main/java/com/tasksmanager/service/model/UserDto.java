package com.tasksmanager.service.model;

import java.time.LocalDate;

/**
 * User DTO model
 *
 * @author SIE
 */
public class UserDto {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate regDate;

    private String confirmStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", regDate=" + regDate +
            ", confirmStatus='" + confirmStatus + '\'' +
            '}';
    }
}
