package com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException;

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
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExchangeRateNotFoundException.class)
    public ResponseEntity<?> handleExchangeRateNotFoundException(ExchangeRateNotFoundException ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadExchangeRateRequestException.class)
    public  ResponseEntity<?> handlesBadExchangeRateRequestException(BadExchangeRateRequestException ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),request.getDescription(false));

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleGeneralException(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),LocalDateTime.now(),request.getDescription(false));

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
