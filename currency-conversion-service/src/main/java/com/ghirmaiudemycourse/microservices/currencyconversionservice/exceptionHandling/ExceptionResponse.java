package com.ghirmaiudemycourse.microservices.currencyconversionservice.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private LocalDateTime timeStamp;
    private String details;
}
