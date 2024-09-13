package com.ghirmaiudemycourse.microservices.currencyconversionservice.controller;

import com.ghirmaiudemycourse.microservices.currencyconversionservice.config.restTemplateConfig.RestTempConfig;
import com.ghirmaiudemycourse.microservices.currencyconversionservice.exceptionHandling.CannotConvertException;
import com.ghirmaiudemycourse.microservices.currencyconversionservice.hystrix.CurrencyConversionInfo;
import com.ghirmaiudemycourse.microservices.currencyconversionservice.model.CurrencyConversion;
import com.ghirmaiudemycourse.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
private CurrencyExchangeProxy proxy;
//    @Autowired
//private RestTemplate restTemplate;
//    @Autowired
//    private RestTempConfig restTempConfig;
    @Autowired
    private CurrencyConversionInfo currencyConversionInfo;

    @Autowired
    private  Environment environment;
//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal
//            quantity) {
//        if (quantity == null || quantity.doubleValue() <= 0)
//            throw new CannotConvertException("it can not convert  " + quantity + " from " + from + " to " + to);
//
//        Map<String,String> uriVariables = new HashMap<>();
//        uriVariables.put("from",from);uriVariables.put("to",to);
//
//ResponseEntity<CurrencyConversion> responseEntity = restTempConfig.getRestTemplate().getForEntity("http://currency-exchange/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
//       CurrencyConversion currencyConversion = responseEntity.getBody();
//
//
//BigDecimal amount = currencyConversion.getConversionMultiple().multiply(quantity);
//
//
//        return  new CurrencyConversion(currencyConversion.getId()
//                ,currencyConversion.getFrom(),currencyConversion.getTo()
//                ,currencyConversion.getConversionMultiple(),quantity,amount,
//                currencyConversion.getEnvironment()+ " "+ "restTemplate");
//    }
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateValueWithFeign(@PathVariable String from,
                                                      @PathVariable String to,
                                                      @PathVariable BigDecimal quantity){

        if(from==null|| to==null||quantity==null||quantity.doubleValue()<=0)
            throw  new CannotConvertException("cannot convert due to one or more information you provide is not valid");
CurrencyConversion currencyConversion = proxy.getExchangeRate(from,to);
return new CurrencyConversion(currencyConversion.getId(),
        from,
        to,
        currencyConversion.getConversionMultiple(),
        quantity,
quantity.multiply(currencyConversion.getConversionMultiple())
       , currencyConversion.getEnvironment()+" - feign");
    }
}
