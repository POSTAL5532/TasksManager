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

    private String first_name;

    private String last_name;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
            "first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
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

