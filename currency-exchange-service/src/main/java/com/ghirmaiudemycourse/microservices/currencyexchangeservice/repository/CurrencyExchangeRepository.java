package com.ghirmaiudemycourse.microservices.currencyexchangeservice.repository;

import com.ghirmaiudemycourse.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

     Optional<CurrencyExchange> findByfromAndTo(String from, String to);
}
