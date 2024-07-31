package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GlobalException {
    @ExceptionHandler(CannotConvertException.class)
    public ResponseEntity<?> handleInconvertibleValues(CannotConvertException ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),request.getDescription(false),LocalDateTime.now());

        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlingRuntimeException(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false),LocalDateTime.now());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
