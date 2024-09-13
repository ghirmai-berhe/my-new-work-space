package com.ghirmaiudemycourse.microservices.currencyexchangeservice.service;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeMapper {

    public CurrencyExchange dtoToCurrencyExchange(CurrencyExchangeDto dto){
        if(dto==null) throw  new UnsupportedOperationException("dto can't be null");


       return  CurrencyExchange.builder()

               .to(dto.getTo())
               .from(dto.getFrom())
               .environment(dto.getEnvironment())
               .conversionMultiple(dto.getConversionMultiple()).build();
    }

    public CurrencyExchangeDto CurrencyExchangeToDto(CurrencyExchange currencyExchange){
        if (currencyExchange==null)throw  new UnsupportedOperationException("currency exchange can't be null");

        return CurrencyExchangeDto.builder()
                .id(currencyExchange.getId())
                .conversionMultiple(currencyExchange.getConversionMultiple())
                .environment(currencyExchange.getEnvironment())
                .from(currencyExchange.getFrom())
                .to(currencyExchange.getTo())
                .build();
    }
}
