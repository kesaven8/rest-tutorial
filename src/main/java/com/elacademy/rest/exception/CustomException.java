package com.elacademy.rest.exception;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message, new Throwable("sdgfhjdhsf"));
    }
}
