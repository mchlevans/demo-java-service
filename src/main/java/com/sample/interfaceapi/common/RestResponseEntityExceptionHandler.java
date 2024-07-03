package com.autos.api.common;

import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    // catch errors from API requests
    @ExceptionHandler(WebClientResponseException.class)
    protected ResponseEntity<Object> handle(WebClientResponseException exception, WebRequest request) {
        
        // this is really specific to the analytics api error response
        ErrorResponse body = exception.getResponseBodyAs(ErrorResponse.class);

        return handleExceptionInternal(exception, body, 
            new HttpHeaders(), exception.getStatusCode(), request);
    }

    // catch validation errors
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request) {
            ErrorResponse body = new ErrorResponse();
            ArrayList<String> errors = new ArrayList<String>();
            
            // get errors
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String errorMessage = error.getDefaultMessage();
                errors.add(errorMessage);
            });

            body.setStatus(HttpStatus.BAD_REQUEST);
            body.setErrors(errors);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

    // catch failures in serializing / deserializing request
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex,
        HttpHeaders headers,
        HttpStatusCode status,
        WebRequest request) {
            ErrorResponse body = new ErrorResponse();
            ArrayList testErrors = new ArrayList<String>();
            
            testErrors.add("Unable to process request body");
            
            body.setStatus(HttpStatus.BAD_REQUEST);
            body.setErrors(testErrors);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

    // catch any remaining unhandled errors
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        ErrorResponse body = new ErrorResponse();
        ArrayList testErrors = new ArrayList<String>();
        
        testErrors.add("Unable to process request");
        
        body.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        body.setErrors(testErrors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
