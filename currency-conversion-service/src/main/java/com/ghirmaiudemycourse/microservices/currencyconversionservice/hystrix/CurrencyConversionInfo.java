package com.ghirmaiudemycourse.microservices.currencyconversionservice.hystrix;

import com.ghirmaiudemycourse.microservices.currencyconversionservice.exceptionHandling.CannotConvertException;
import com.ghirmaiudemycourse.microservices.currencyconversionservice.model.CurrencyConversion;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class CurrencyConversionInfo {
//    @Autowired
//    private RestTemplate restTemplate;
//
////    @HystrixCommand(fallbackMethod = "getFallbackConvertedValue", commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
////            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
////            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
////            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
////    })
//    public CurrencyConversion getConvertedValue(String from, String to, BigDecimal quantity) {
//        if (quantity == null || quantity.doubleValue() <= 0)
//            throw new CannotConvertException("cannot convert  " + quantity + " " + from + " to " + to);
//        HashMap<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//        ResponseEntity<CurrencyConversion> conversionResponseEntity = restTemplate.getForEntity("http://currency-exchange/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
//
//        CurrencyConversion currencyConversion = conversionResponseEntity.getBody();
//        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
//    }
//
//    private CurrencyConversion getFallbackConvertedValue(String from, String to, BigDecimal quantity){
//
//        return new CurrencyConversion(Long.valueOf(999999l),"  No Currency "+from,"to No Currency "+to,BigDecimal.ZERO,quantity,BigDecimal.ZERO,"no environment");
//    }
}
