package com.BitirmeProjesi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> methodExceptionHandler(Exception ex) {
        String  message = ex.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
