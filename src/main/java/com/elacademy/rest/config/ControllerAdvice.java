package com.elacademy.rest.config;

import com.elacademy.rest.dto.ErrorMessage;
import com.elacademy.rest.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleAllCustomException(CustomException customException, WebRequest request) {
        System.out.println("This is a custom Exception");
        return new ResponseEntity<>(new ErrorMessage(customException.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = RuntimeException.class)
    public void handleAllException() {
        System.out.println(" I am handling all the exception");
    }

}
