package com.tasksmanager.service.model.user;

import javax.persistence.*;

import java.sql.Date;

import com.tasksmanager.service.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User model
 *
 * @author SIE
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
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
}

