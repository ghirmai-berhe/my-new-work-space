package com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException;

public class ExchangeRateNotFoundException extends RuntimeException{
   public ExchangeRateNotFoundException(String message){
       super(message);
   }
}
