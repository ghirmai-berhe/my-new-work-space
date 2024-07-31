package com.ghirmaiudemycourse.microservices.currencyexchangeservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="currency_from" )
    private String from;
    @Column(name="currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public CurrencyExchange( String from, String to, BigDecimal conversionMultiple) {

        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
