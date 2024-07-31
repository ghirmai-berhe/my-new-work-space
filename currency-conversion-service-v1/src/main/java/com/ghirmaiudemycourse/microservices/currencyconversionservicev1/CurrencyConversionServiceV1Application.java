package com.ghirmaiudemycourse.microservices.currencyconversionservicev1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceV1Application.class, args);
	}

}
