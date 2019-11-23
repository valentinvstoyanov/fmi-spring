package com.valentinvstoyanov.bloggerrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {
    HttpStatus httpStatus;
    String message;
}
