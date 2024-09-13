package com.ghirmaiudemycourse.microservices.currencyconversionservice.model;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private String environment;

}
