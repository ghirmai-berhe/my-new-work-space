package com.ghirmaiudemycourse.microservices.currencyexchangeservice.controller;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException.BadExchangeRateRequestException;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.service.CurrencyExchangeServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Environment environment;
    private CurrencyExchangeServiceImpl exchangeService;
public  CurrencyExchangeController(Environment environment , CurrencyExchangeServiceImpl exchangeService){
    this.exchangeService =exchangeService;
    this.environment = environment;
}

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeDto getExchangeRate(@PathVariable String from, @PathVariable String to){

        logger.info("getExchangeRate method call with {} to  and {}",from,to);


        CurrencyExchangeDto currencyExchange =exchangeService.getExchangeRate(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;

    }

}
