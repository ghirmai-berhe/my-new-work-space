package com.ghirmaiudemycourse.microservices.currencyconversionservice.exceptionHandling;

public class CannotConvertException extends RuntimeException{
    public CannotConvertException(String message){
        super(message);
    }
}
