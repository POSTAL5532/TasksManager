package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.tasksmanager.service.controller.user.validator.CorrectUserPassword;
import com.tasksmanager.service.utils.ValidationUtils;

/**
 * Change current user password Request.
 *
 * @author SIE
 */
public class ChangePasswordRequest {

    @NotBlank(message = "Previous password must be specified")
    @Pattern(regexp = ValidationUtils.PASSWORD_PATTERN, message = "Previous password is incorrect")
    @CorrectUserPassword(message = "Not correct user password")
    private String prevPassword;

    @NotBlank(message = "New password must be specified")
    @Pattern(regexp = ValidationUtils.PASSWORD_PATTERN, message = "New password is incorrect")
    private String newPassword;

    public String getPrevPassword() {
        return prevPassword;
    }

    public void setPrevPassword(String prevPassword) {
        this.prevPassword = prevPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ChangePasswordRequest{" +
            "prevPassword='" + prevPassword + '\'' +
            ", newPassword='" + newPassword + '\'' +
            '}';
    }
}
