package com.tasksmanager.service.exception;

/**
 * When user has not access to project.
 *
 * @author SIE
 */
public class UserHasNotToProjectAccessException extends RuntimeException {

    public UserHasNotToProjectAccessException(String message) {
        super(message);
    }

    public UserHasNotToProjectAccessException() {
        super();
    }
}
