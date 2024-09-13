package com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeDto {
    private Long id;
    @NotNull
    @NotBlank
    private String from;
    @NotNull
    @NotBlank
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
