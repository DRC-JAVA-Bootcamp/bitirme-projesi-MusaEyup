package com.BitirmeProjesi.exceptions;


public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
