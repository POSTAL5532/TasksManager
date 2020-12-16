package com.tasksmanager.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Api error response model.
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
public class ApiError {

    /**
     * Response status.
     */
    private HttpStatus status;

    /**
     * Api error type.
     */
    private ApiErrorType apiErrorType;

    /**
     * General error message.
     */
    private String message;

    /**
     * Model fields errors.
     */
    private List<NameValue> errors;

    public ApiError(ApiErrorType apiErrorType, HttpStatus status, String message, List<NameValue> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors == null ? new ArrayList<>() : errors;
        this.apiErrorType = apiErrorType;
    }

    public ApiError(ApiErrorType apiErrorType, HttpStatus status, String message) {
        this(apiErrorType, status, message, null);
    }
}
