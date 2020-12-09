package com.tasksmanager.service.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Api error response model.
 *
 * @author SIE
 */
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }

    public void setApiErrorType(ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NameValue> getErrors() {
        return errors;
    }

    public void setErrors(List<NameValue> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiError{" +
            "status=" + status +
            ", apiErrorType=" + apiErrorType +
            ", message='" + message + '\'' +
            ", errors=" + errors +
            '}';
    }
}
