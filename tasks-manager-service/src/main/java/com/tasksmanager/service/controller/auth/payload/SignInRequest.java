package com.tasksmanager.service.controller.auth.payload;

import javax.validation.constraints.NotBlank;

import com.tasksmanager.service.controller.auth.validator.UserExist;

/**
 * @author SIE
 */
public class SignInRequest {

    @NotBlank(message = "Email не должен быть пустым")
    @UserExist
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;

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

    @Override
    public String toString() {
        return "SignInRequest{" +
            "email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
