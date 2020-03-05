package com.tele.greeting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConflict(ConstraintViolationException e) {
        log.info("Returning HTTP 400 Bad Request", e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<?> handleConflict(UnsupportedOperationException e) {
        log.info("Returning HTTP 501 Not Implemented", e);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(e.getMessage());
    }


}
