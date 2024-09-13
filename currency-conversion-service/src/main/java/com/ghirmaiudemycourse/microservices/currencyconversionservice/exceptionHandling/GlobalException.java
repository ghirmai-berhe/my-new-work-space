package com.ghirmaiudemycourse.microservices.currencyconversionservice.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CannotConvertException.class)
    public ResponseEntity<?> handlesInconvertibleValues(CannotConvertException ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlesRuntimeException(RuntimeException ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),LocalDateTime.now(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
