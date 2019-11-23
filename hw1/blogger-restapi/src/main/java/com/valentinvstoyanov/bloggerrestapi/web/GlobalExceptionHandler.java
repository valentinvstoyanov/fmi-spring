package com.valentinvstoyanov.bloggerrestapi.web;

import com.valentinvstoyanov.bloggerrestapi.exception.IllegalEntityBodyException;
import com.valentinvstoyanov.bloggerrestapi.exception.NonExistingEntityException;
import com.valentinvstoyanov.bloggerrestapi.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError> handleExceptions(NonExistingEntityException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleExceptions(IllegalEntityBodyException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
