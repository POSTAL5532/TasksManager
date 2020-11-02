package com.tasksmanager.service.controller.auth.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tasksmanager.service.controller.auth.validator.EmailUniqueness;
import com.tasksmanager.service.controller.auth.validator.PasswordEquivalence;

/**
 * @author SIE
 */
@PasswordEquivalence(password = "password", passwordMatch = "rPassword", message = "Пароли не совпадают")
public class SignUpRequest {

    @JsonIgnore
    public static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$";

    @JsonIgnore
    public static final String NAME_PATTERN = "^\\w{2,255}$";

    @NotBlank(message = "Имя не должно быть пустым")
    @Pattern(regexp = NAME_PATTERN, message = "Значение имени не корректно")
    private String firstName;

    @NotBlank(message = "Имя не должно быть пустым")
    @Pattern(regexp = NAME_PATTERN, message = "Значение имени не корректно")
    private String lastName;

    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Значение Email не корректно")
    @EmailUniqueness(message = "Пользователь с таким email уже зарегестрирован")
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Значение пароля не корректно")
    private String password;

    @JsonProperty("rPassword")
    @NotBlank(message = "Повторный пароль не должен быть пустым")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Значение повторного пароля не корректно")
    private String rPassword;

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

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", rPassword='" + rPassword + '\'' +
            '}';
    }
}
