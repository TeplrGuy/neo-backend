package com.neostarteon.backend.exceptions;

import org.springframework.http.HttpStatus;

/**
 * https://www.toptal.com/java/spring-boot-rest-api-error-handling
 */
public abstract class HttpErrorException extends Exception {
    public HttpStatus httpStatus;
    public String message;

}
