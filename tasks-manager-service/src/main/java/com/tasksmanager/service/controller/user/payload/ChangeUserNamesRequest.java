package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.tasksmanager.service.utils.ValidationUtils;

import lombok.Getter;
import lombok.ToString;

/**
 * Change user names request.
 *
 * @author SIE
 */
@Getter
@ToString
public class ChangeUserNamesRequest {

    @NotBlank(message = "First name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Name is incorrect")
    private String firstName;

    @NotBlank(message = "Last name must be specified")
    @Pattern(regexp = ValidationUtils.USER_NAME_PATTERN, message = "Last name is incorrect")
    private String lastName;
}
