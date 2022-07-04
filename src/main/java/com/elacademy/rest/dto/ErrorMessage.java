package com.elacademy.rest.dto;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
