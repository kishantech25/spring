package com.kishan.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ErrorResponse> handleJobPostNotFound(JobPostNotFoundException ex, HttpServletRequest request){

        ErrorResponse response =new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(404);
        response.setError("Not Found");
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex,HttpServletRequest request){
         ErrorResponse response =new ErrorResponse();
         response.setTimestamp(LocalDateTime.now());
         response.setStatus(500);
         response.setError("Internal Server Errror");
         response.setMessage(ex.getMessage());
         response.setPath(request.getRequestURI());

         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
