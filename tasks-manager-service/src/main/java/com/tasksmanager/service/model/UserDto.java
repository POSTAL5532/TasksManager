package com.tasksmanager.service.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User DTO model
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
public class UserDto {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate regDate;

    private String confirmStatus;
}
