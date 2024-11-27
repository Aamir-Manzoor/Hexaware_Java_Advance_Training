package com.hexaware.hotpot.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    private final HttpStatus status;

    public BadRequestException(HttpStatus status, String message) {
        super(message); // Use RuntimeException's message handling
        this.status = status;
    }

    public BadRequestException(HttpStatus status, String message, Throwable cause) {
        super(message, cause); // Allow chaining exceptions
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
