package com.secnanifymone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secnanifymone.models.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
	CurrencyConversion findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
