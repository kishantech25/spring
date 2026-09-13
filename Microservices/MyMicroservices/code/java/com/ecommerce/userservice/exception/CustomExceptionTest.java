package com.ecommerce.userservice.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Custom Exception Tests")
class CustomExceptionTest {

    @Test
    @DisplayName("Should create ResourceNotFoundException with message")
    void testResourceNotFoundExceptionMessage() {
        String message = "User not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should create ResourceNotFoundException with message and cause")
    void testResourceNotFoundExceptionWithCause() {
        String message = "User not found";
        Throwable cause = new RuntimeException("Database error");
        ResourceNotFoundException exception = new ResourceNotFoundException(message, cause);

        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("Should create ResourceAlreadyExistsException with message")
    void testResourceAlreadyExistsExceptionMessage() {
        String message = "Email already exists";
        ResourceAlreadyExistsException exception = new ResourceAlreadyExistsException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    @DisplayName("Should create ResourceAlreadyExistsException with message and cause")
    void testResourceAlreadyExistsExceptionWithCause() {
        String message = "Email already exists";
        Throwable cause = new RuntimeException("Constraint violation");
        ResourceAlreadyExistsException exception = new ResourceAlreadyExistsException(message, cause);

        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    @DisplayName("Should create ApiError with all fields")
    void testApiErrorCreation() {
        int status = 404;
        String message = "Resource not found";
        String error = "NOT_FOUND";
        String path = "/api/v1/users/999";

        ApiError apiError = new ApiError(status, message, error, path);

        assertEquals(status, apiError.getStatus());
        assertEquals(message, apiError.getMessage());
        assertEquals(error, apiError.getError());
        assertEquals(path, apiError.getPath());
        assertNotNull(apiError.getTimestamp());
    }

    @Test
    @DisplayName("Should update ApiError fields")
    void testApiErrorUpdate() {
        ApiError apiError = new ApiError(400, "Bad request", "BAD_REQUEST", "/api/test");

        apiError.setStatus(500);
        apiError.setMessage("Internal server error");
        apiError.setError("SERVER_ERROR");

        assertEquals(500, apiError.getStatus());
        assertEquals("Internal server error", apiError.getMessage());
        assertEquals("SERVER_ERROR", apiError.getError());
    }

    @Test
    @DisplayName("Should handle ResourceNotFoundException inheritance")
    void testResourceNotFoundExceptionInheritance() {
        ResourceNotFoundException exception = new ResourceNotFoundException("Not found");
        
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    @DisplayName("Should handle ResourceAlreadyExistsException inheritance")
    void testResourceAlreadyExistsExceptionInheritance() {
        ResourceAlreadyExistsException exception = new ResourceAlreadyExistsException("Already exists");
        
        assertTrue(exception instanceof RuntimeException);
    }
}
