package com.ghirmaiudemycourse.microservices.currencyconversionservice.proxy;





import com.ghirmaiudemycourse.microservices.currencyconversionservice.model.CurrencyConversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "currency-exchange",url = "localhost:8000") // here with out load balancing

@FeignClient(name ="currency-exchange" )// here with load balancing
public interface CurrencyExchangeProxy {


    @GetMapping("currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeRate(@PathVariable String from,@PathVariable String to);
}

