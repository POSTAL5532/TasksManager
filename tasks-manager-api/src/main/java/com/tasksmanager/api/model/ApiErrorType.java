package com.tasksmanager.api.model;

/**
 * Api error types.
 *
 * @author SIE
 */
public enum ApiErrorType {

    /**
     * Not typed error.
     */
    OTHER_API_ERROR,

    /**
     * Request validation error.
     */
    VALIDATION_ERROR,

    /**
     * User not have access to project error.
     */
    PROJECT_LEVEL_ACCESS_ERROR,

    /**
     * User not have access to operation error.
     */
    OPERATION_LEVEL_ACCESS_ERROR,

    /**
     * Requested resource not found error.
     */
    NOT_FOUND_ERROR
}
