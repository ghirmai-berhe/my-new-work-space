package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.controller;

import com.ghirmaiudemycourse.microservices.currencyconversionservicev1.config.restTesmplateConfig.RestTemplateConfig;
import com.ghirmaiudemycourse.microservices.currencyconversionservicev1.exceptionHandling.CannotConvertException;
import com.ghirmaiudemycourse.microservices.currencyconversionservicev1.model.CurrencyConversion;
import com.ghirmaiudemycourse.microservices.currencyconversionservicev1.proxy.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.client.RestTemplateBuilder;
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
    private RestTemplateConfig restTemplateConfig;
@Autowired
private CurrencyExchangeProxy currencyExchangeProxy;
    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);



   @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateValue(@PathVariable String from , @PathVariable String to,@PathVariable BigDecimal quantity){
        if(from==null||from.isEmpty()||to==null||to.isEmpty()||quantity==null||quantity.doubleValue()<=0)
            throw  new CannotConvertException("it can not convert = >"+quantity + "from =>"+ from + " to =>"+to);
        Map<String,String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);

        ResponseEntity<CurrencyConversion> response =restTemplateConfig.getRestTemplate()
               .getForEntity("http://currency-exchange/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariable);

       CurrencyConversion captured = response.getBody();
logger.info(" the captured ->{} ",captured);
       BigDecimal amount = captured.getConversionMultiple().multiply(quantity);

        return new CurrencyConversion(
                captured.getId(),
                captured.getFrom(),
                captured.getTo(),
                captured.getConversionMultiple(),
                quantity,
                amount,
                captured.getEnvironment()+" == restTemplate"

        );
    }


    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculatedValueWithFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity){
        if(from==null||from.isEmpty()||to==null||to.isEmpty()||quantity==null||quantity.doubleValue()<=0)
            throw new CannotConvertException("we can not convert "+quantity + " from "+ from + "  to"+ to);

        CurrencyConversion response = currencyExchangeProxy.getExchangeRate(from,to);
        BigDecimal amount = response.getConversionMultiple().multiply(quantity);

logger.info("currency-exchange-feign call received -> {}",response);
        return new CurrencyConversion(response.getId(),response.getFrom(),response.getTo()
           ,response.getConversionMultiple(),quantity,amount,response.getEnvironment()+" =>feign");
    }
}
