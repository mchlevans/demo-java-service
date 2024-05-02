package com.autos.api.common;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    // As is, this will only pick up one type of exception: WebClientResponseException
    // Can add more types of exceptions to ExceptionHandler but will need to update
    // type of first argument to handle function
    @ExceptionHandler(WebClientResponseException.class)
    protected ResponseEntity<Object> handle(WebClientResponseException exception, WebRequest request) {
        logger.info("Exception handeled in RestResponseEntityExceptionHandler.handle");
        
        ErrorResponse body = exception.getResponseBodyAs(ErrorResponse.class);
        return handleExceptionInternal(exception, body, 
            new HttpHeaders(), exception.getStatusCode(), request);
    }
}
