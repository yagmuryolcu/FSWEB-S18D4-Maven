package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;

public class BurgerException extends RuntimeException{
    private HttpStatus httpStatus;


    public BurgerException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public BurgerException(String message, Long id) {
        super(message + id);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
