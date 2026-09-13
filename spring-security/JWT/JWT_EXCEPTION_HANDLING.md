# JWT Exception Handling Documentation

## Overview
This document explains the exception handling implementation for JWT token parsing and validation in the Spring Security project.

## Exception Classes

### JwtException
Custom exception class for JWT-related errors with error codes for better error tracking.

**Location:** `com.telusko.springsecdemo.exception.JwtException`

**Error Codes:**
- `INVALID_TOKEN` - Token is null or empty
- `EXPIRED_TOKEN` - JWT token has expired
- `UNSUPPORTED_TOKEN` - JWT token is not supported
- `MALFORMED_TOKEN` - Invalid JWT token format
- `INVALID_SIGNATURE` - JWT signature validation failed
- `EMPTY_CLAIMS` - JWT claims string is empty
- `UNKNOWN_ERROR` - Unexpected error during parsing
- `EXTRACT_ERROR` - Failed to extract username from token
- `INVALID_USER` - User details are null or invalid
- `VALIDATION_ERROR` - General token validation failure

## Exception Handling Points

### 1. **JwtService.extractAllClaims()**
Handles JWT parsing exceptions and converts them to `JwtException`:
```
- ExpiredJwtException → EXPIRED_TOKEN
- UnsupportedJwtException → UNSUPPORTED_TOKEN
- MalformedJwtException → MALFORMED_TOKEN
- SignatureException → INVALID_SIGNATURE
- IllegalArgumentException → EMPTY_CLAIMS
- Other exceptions → UNKNOWN_ERROR
```

### 2. **JwtService.extractUserName()**
Wraps username extraction with try-catch:
```
- JwtException → Re-thrown as-is
- Other exceptions → Converted to JwtException with EXTRACT_ERROR code
```

### 3. **JwtService.validateToken()**
Validates token and user details:
```
- Null/empty token → INVALID_TOKEN
- Null user details → INVALID_USER
- Validation failures → VALIDATION_ERROR
- JwtException from extractUserName → Re-thrown
```

### 4. **JwtFilter.doFilterInternal()**
Gracefully handles exceptions during authentication filter:
```
- Token extraction errors → Logged as warning, request continues without authentication
- Token validation errors → Logged as warning, request continues without authentication
- User loading errors → Logged as error with stack trace
- Filter continues regardless of JWT processing errors
```

## Error Handling Flow

```
HTTP Request with Authorization Header
         ↓
JwtFilter.doFilterInternal()
    ├─→ Extract "Bearer" token
    │     └─→ Call extractUserName() → JwtException caught & logged
    │
    ├─→ If username extracted successfully
    │     ├─→ Load user details
    │     │     └─→ UserDetailsService exception → logged as error
    │     │
    │     └─→ Validate token → JwtException caught & logged
    │           ├─→ If valid → Set Spring Security Authentication
    │           └─→ If invalid → Log warning
    │
    └─→ Continue filter chain (with or without authentication)
```

## Usage Examples

### Catching Specific JWT Errors
```java
try {
    String username = jwtService.extractUserName(token);
} catch (JwtException e) {
    switch (e.getErrorCode()) {
        case "EXPIRED_TOKEN":
            // Handle expired token
            break;
        case "INVALID_SIGNATURE":
            // Handle invalid signature
            break;
        case "MALFORMED_TOKEN":
            // Handle malformed token
            break;
        default:
            // Handle other errors
            break;
    }
}
```

### Logging JWT Errors
```java
catch (JwtException e) {
    logger.warn("JWT Error [" + e.getErrorCode() + "]: " + e.getMessage());
}
```

## Benefits

✅ **Robustness** - Application doesn't crash on invalid tokens
✅ **Debugging** - Error codes help identify specific issues
✅ **Security** - Graceful degradation when token validation fails
✅ **Logging** - All errors are properly logged for monitoring
✅ **User Experience** - Invalid/expired tokens don't break the request flow
✅ **Maintainability** - Centralized exception handling in one custom class

## Security Considerations

1. **Error Messages** - Error codes are returned; detailed messages are only logged
2. **No Token Leakage** - Token content is never logged in error messages
3. **Graceful Failure** - Invalid tokens result in unauthenticated access, not 500 errors
4. **Logging** - Warnings logged for failed extraction/validation, errors for unexpected issues
