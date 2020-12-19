package com.tasksmanager.api.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasksmanager.api.model.ApiError;
import com.tasksmanager.api.model.ApiErrorType;
import com.tasksmanager.api.model.NameValue;

/**
 * Global exceptions handlers. Convert exceptions to HTTP response
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * MethodArgumentNotValidException handler. Convert MethodArgumentNotValidException to response with 400 HTTP code
     * {@link ApiError} and errors mapping list {@link NameValue}.
     *
     * @param exception exception
     * @param headers   headers
     * @param status    http status
     * @param request   http request
     * @return {@link ApiError} response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<NameValue> errors = new ArrayList<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.add(new NameValue(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        for (ObjectError objectError : exception.getBindingResult().getGlobalErrors()) {
            errors.add(new NameValue(objectError.getObjectName(), objectError.getDefaultMessage()));
        }

        ApiError apiError = new ApiError(ApiErrorType.VALIDATION_ERROR, HttpStatus.BAD_REQUEST, "Request validation error", errors);

        return handleExceptionInternal(exception, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    /**
     * NoSuchElementException handler. Convert NoSuchElementException to response with 404 HTTP code.
     *
     * @param exception exception
     * @param request   request
     * @return 404 HTTP response
     */
    @ExceptionHandler(value = NoSuchElementException.class)
    public final ResponseEntity<Object> noSuchElementException(NoSuchElementException exception, WebRequest request) {
        ApiError apiError = new ApiError(ApiErrorType.NOT_FOUND_ERROR, HttpStatus.NOT_FOUND, exception.getMessage());
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    /**
     * UserHasNotToProjectAccessException handler. Convert UserHasNotToProjectAccessException to response with 403 HTTP code.
     *
     * @param exception exception
     * @param request   request
     * @return 403 HTTP response
     */
    @ExceptionHandler(value = UserHasNotToProjectAccessException.class)
    public final ResponseEntity<Object> userHasNotToProjectAccessException(UserHasNotToProjectAccessException exception, WebRequest request) {
        ApiError apiError = new ApiError(ApiErrorType.PROJECT_LEVEL_ACCESS_ERROR, HttpStatus.FORBIDDEN, exception.getMessage());
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    /**
     * UserHasNotToOperationAccessException handler. Convert UserHasNotToOperationAccessException to response with 403 HTTP code.
     *
     * @param exception exception
     * @param request   request
     * @return 403 HTTP response
     */
    @ExceptionHandler(value = UserHasNotToOperationAccessException.class)
    public final ResponseEntity<Object> userHasNotToOperationAccessException(UserHasNotToOperationAccessException exception, WebRequest request) {
        ApiError apiError = new ApiError(ApiErrorType.OPERATION_LEVEL_ACCESS_ERROR, HttpStatus.FORBIDDEN, exception.getMessage());
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
}
