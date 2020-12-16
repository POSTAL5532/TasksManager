package com.tasksmanager.api.utils;

/**
 * Validation util-class.
 *
 * @author SIE
 */
public class ValidationUtils {

    public static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$";
    public static final String USER_NAME_PATTERN = "^\\w{2,255}$";
}
