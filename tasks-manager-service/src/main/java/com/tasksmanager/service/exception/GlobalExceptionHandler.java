package com.tasksmanager.service.exception;

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

import com.tasksmanager.service.model.ApiError;
import com.tasksmanager.service.model.NameValue;

/**
 * Global exceptions handlers. Convert exceptions to HTTP response
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * NoSuchElementException handler. Convert NoSuchElementException to response with 404 HTTP code.
     *
     * @param exception exception
     * @param request   request
     * @return 404 HTTP response
     */
    @ExceptionHandler(value = NoSuchElementException.class)
    public final ResponseEntity<Object> noSuchElementException(NoSuchElementException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

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

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Request validation error", errors);

        return handleExceptionInternal(exception, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }
}
