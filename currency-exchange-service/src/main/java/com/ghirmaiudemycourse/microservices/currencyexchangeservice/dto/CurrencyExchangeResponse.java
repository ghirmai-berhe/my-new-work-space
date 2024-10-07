package com.ghirmaiudemycourse.microservices.currencyexchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchangeResponse {
    private List<CurrencyExchangeDto> list;
    private int pageNo;
    private int pageSize;
    private  long totalElements;
    private  int totalPages;
    private boolean last;
}
