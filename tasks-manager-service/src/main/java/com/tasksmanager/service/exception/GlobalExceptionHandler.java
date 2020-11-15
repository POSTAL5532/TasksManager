package com.tasksmanager.service.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exceptions handlers. Convert exceptions to HTTP response
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Convert NoSuchElementException to response with 404 HTTP code.
     *
     * @param exception exception
     * @param request   request
     * @return 404 HTTP response
     */
    @ExceptionHandler(value = NoSuchElementException.class)
    public final ResponseEntity<Object> validationException(NoSuchElementException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
