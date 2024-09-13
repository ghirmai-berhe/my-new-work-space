package com.ghirmaiudemycourse.microservices.currencyexchangeservice.service;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException.ExchangeRateNotFoundException;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeImpl implements CurrencyExchangeService{
private CurrencyExchangeRepository exchangeRepository;
private  CurrencyExchangeMapper mapper;

public CurrencyExchangeImpl(CurrencyExchangeMapper mapper, CurrencyExchangeRepository exchangeRepository){
    this.mapper =mapper;
    this.exchangeRepository =exchangeRepository;
}
    @Override
    public CurrencyExchangeDto getExchangeRate(String from, String to) {
        CurrencyExchange currencyExchange = exchangeRepository.findByFromAndTo(from, to)
                .orElseThrow(()->new ExchangeRateNotFoundException("we coldn't find exchange rate with from = "+from +" to = "+to));

        return mapper.CurrencyExchangeToDto(currencyExchange);
    }
}
