package com.valentinvstoyanov.bloggerrestapi.exception;

public class NonExistingEntityException extends Exception {
    public NonExistingEntityException(String message) {
        super(message);
    }
}
