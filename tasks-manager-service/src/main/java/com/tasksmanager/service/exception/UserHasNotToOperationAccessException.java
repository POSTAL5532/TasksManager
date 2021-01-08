package com.tasksmanager.service.exception;

/**
 * When user has not access to operation.
 *
 * @author SIE
 */
public class UserHasNotToOperationAccessException extends RuntimeException {

    public UserHasNotToOperationAccessException() {
    }

    public UserHasNotToOperationAccessException(String message) {
        super(message);
    }
}
