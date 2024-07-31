package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.proxy;

import com.ghirmaiudemycourse.microservices.currencyconversionservicev1.model.CurrencyConversion;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
  CurrencyConversion getExchangeRate(@PathVariable String from, @PathVariable String to);

}
