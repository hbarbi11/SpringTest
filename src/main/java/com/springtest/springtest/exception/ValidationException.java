package com.springtest.springtest.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends Exception {

    HttpStatus httpStatus;

    public ValidationException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public ValidationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
