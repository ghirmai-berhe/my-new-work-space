package com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException;

public class BadExchangeRateRequestException extends RuntimeException {
    public BadExchangeRateRequestException(String message){
        super(message);
    }
}
