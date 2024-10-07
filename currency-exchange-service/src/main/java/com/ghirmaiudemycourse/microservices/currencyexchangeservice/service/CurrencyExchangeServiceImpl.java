package com.ghirmaiudemycourse.microservices.currencyexchangeservice.service;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto.CurrencyExchangeResponse;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException.ExchangeRateNotFoundException;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.ghirmaiudemycourse.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService{
private CurrencyExchangeRepository exchangeRepository;
private  CurrencyExchangeMapper mapper;

public CurrencyExchangeServiceImpl(CurrencyExchangeMapper mapper, CurrencyExchangeRepository exchangeRepository){
    this.mapper =mapper;
    this.exchangeRepository =exchangeRepository;
}
    @Override
    public CurrencyExchangeDto getExchangeRate(String from, String to) {
        CurrencyExchange currencyExchange = exchangeRepository.findByFromAndTo(from, to)
                .orElseThrow(()->new ExchangeRateNotFoundException("we coldn't find exchange rate with from = "+from +" to = "+to));

        return mapper.CurrencyExchangeToDto(currencyExchange);
    }

    @Override
    public CurrencyExchangeResponse getAllExchange(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<CurrencyExchange> page = exchangeRepository.findAll(pageable);
        List<CurrencyExchangeDto> currencyExchangeList = page.getContent().stream()
                .map(mapper::CurrencyExchangeToDto).toList();

        return CurrencyExchangeResponse.builder()
                .list(currencyExchangeList)
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();

    }
}
