package com.tasksmanager.data.model.user;

import javax.persistence.*;

import java.sql.Date;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * User model
 *
 * @author SIE
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "reg_date")
    private Date regDate;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private UserConfirmStatus confirmStatus;

    public User() {
        super();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserConfirmStatus getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(UserConfirmStatus confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    @Override
    public String toString() {
        return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", role=" + role +
            ", regDate=" + regDate +
            ", status=" + status +
            ", confirmStatus=" + confirmStatus +
            ", id='" + id + '\'' +
            '}';
    }
}

