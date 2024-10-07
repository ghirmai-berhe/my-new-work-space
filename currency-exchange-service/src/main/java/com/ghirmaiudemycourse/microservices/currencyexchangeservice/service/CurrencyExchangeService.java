package com.ghirmaiudemycourse.microservices.currencyexchangeservice.service;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeResponse;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;


public interface CurrencyExchangeService {
    CurrencyExchangeDto getExchangeRate(String from, String to);
    CurrencyExchangeResponse getAllExchange(int pageNo , int pageSize);

}
