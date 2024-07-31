package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private String details;
    private LocalDateTime timeStamp;
}
