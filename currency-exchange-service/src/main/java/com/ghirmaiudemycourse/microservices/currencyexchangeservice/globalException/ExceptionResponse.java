package com.ghirmaiudemycourse.microservices.currencyexchangeservice.globalException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private LocalDateTime timeStamp;
    private String details;
}
