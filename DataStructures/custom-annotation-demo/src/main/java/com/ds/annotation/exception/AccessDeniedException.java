package com.ds.annotation.exception;

public class AccessDeniedException extends  RuntimeException{
    public AccessDeniedException(String message) {
        super(message);
    }
}
