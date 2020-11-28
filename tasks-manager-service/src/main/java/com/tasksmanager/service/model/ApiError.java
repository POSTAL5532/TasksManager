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
     * General error message.
     */
    private String message;

    /**
     * Model fields errors.
     */
    private List<NameValue> errors;

    public ApiError(HttpStatus status, String message, List<NameValue> errors) {
        this.status = status;
        this.message = message;

        this.errors = errors == null ? new ArrayList<>() : errors;
    }

    public ApiError(HttpStatus status, String message) {
        this(status, message, null);
    }

    public ApiError(HttpStatus status, List<NameValue> errors) {
        this(status, null, errors);
    }

    public ApiError(String message, List<NameValue> errors) {
        this(null, message, errors);
    }

    public ApiError(String message) {
        this(null, message, null);
    }

    public ApiError(List<NameValue> errors) {
        this(null, null, errors);
    }

    public ApiError(HttpStatus status) {
        this(status, null, null);
    }

    public ApiError() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
            ", message='" + message + '\'' +
            ", errors=" + errors +
            '}';
    }
}
