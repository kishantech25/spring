package com.kishan.exception;

public class DuplicateJobPostException extends RuntimeException {

    public DuplicateJobPostException(String message){
        super(message);
    }

}
