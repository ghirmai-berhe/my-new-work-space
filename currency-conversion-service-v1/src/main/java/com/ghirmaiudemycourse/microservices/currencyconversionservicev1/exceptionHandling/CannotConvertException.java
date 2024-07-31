package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.exceptionHandling;




public class CannotConvertException extends RuntimeException{

    public CannotConvertException(String message){
        super(message);
    }
}
