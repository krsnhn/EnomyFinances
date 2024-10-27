package com.secnanifymone.services;

public interface CurrencyConversionService {
    Double convertCurrency(String fromCurrency, String toCurrency, Double amount);
}

