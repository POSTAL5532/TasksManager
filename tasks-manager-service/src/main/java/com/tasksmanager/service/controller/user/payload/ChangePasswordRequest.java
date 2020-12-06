package com.tasksmanager.service.controller.user.payload;

import javax.validation.constraints.NotBlank;

import com.tasksmanager.service.controller.user.validator.CorrectUserPassword;

/**
 * Change current user password Request.
 *
 * @author SIE
 */
public class ChangePasswordRequest {

    @NotBlank(message = "Prev password must be specified")
    @CorrectUserPassword(message = "Not correct user password")
    private String prevPassword;

    @NotBlank(message = "New password must be specified")
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
