package com.ghirmaiudemycourse.microservices.currencyexchangeservice.controller;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException.ExchangeRateNotFoundException;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeRate(@PathVariable String from, @PathVariable String to){

        logger.info("getExchangeRate method call with {} to  and {}",from,to);
        Optional<CurrencyExchange> exObject = repository.findByfromAndTo(from,to);
        if(exObject.isEmpty()){
            throw new ExchangeRateNotFoundException(" no ex-rate found  from "+from+" to "+to);
        }
        CurrencyExchange currencyExchange =exObject.get();
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;

    }

}
