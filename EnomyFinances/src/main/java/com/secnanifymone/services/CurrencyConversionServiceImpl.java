package com.secnanifymone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secnanifymone.models.CurrencyConversion;
import com.secnanifymone.models.MyUser;
import com.secnanifymone.models.TotalBalanceUsd;
import com.secnanifymone.models.UserCurrencyBalance;
import com.secnanifymone.repositories.CurrencyConversionRepository;
import com.secnanifymone.repositories.TotalBalanceUsdRepository;
import com.secnanifymone.repositories.UserCurrencyBalanceRepository;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
	
	@Autowired
    private UserService userService;

    @Autowired
    private CurrencyConversionRepository conversionRepository;
    
    @Autowired
    private TotalBalanceUsdRepository totalBalanceUsdRepository;

    @Autowired
    private UserCurrencyBalanceRepository userCurrencyBalanceRepository;


    @Override
    public Double convertCurrency(String fromCurrency, String toCurrency, Double amount) {
        // Fetch conversion rates
        CurrencyConversion fromConversion = conversionRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
        CurrencyConversion toConversion = conversionRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
        
        System.out.println("From Currency: " + fromCurrency);
        System.out.println("To Currency: " + toCurrency);

        if (fromConversion == null || toConversion == null) {
            throw new IllegalArgumentException("Conversion rates not found for the specified currencies.");
        }

        double fromConversionRate = fromConversion.getConversionRate();
        double toConversionRate = toConversion.getConversionRate();

        // Convert amount to USD
        double amountInUSD = (!fromCurrency.equals("USD")) ? amount / fromConversionRate : amount;

        // Calculate amount in target currency
        double result = amountInUSD * toConversionRate;

        // Calculate fees
        double feePercentage = calculateFeePercentage(amount);
        double fee = result * feePercentage;

        // Deduct fee from total balance in USD
        MyUser currentUser = userService.getCurrentUser();
        TotalBalanceUsd totalBalanceUsd = (TotalBalanceUsd) totalBalanceUsdRepository.findByUser(currentUser);
        double newTotalBalanceUSD = totalBalanceUsd.getAmount() - amountInUSD - fee;
        totalBalanceUsd.setAmount(newTotalBalanceUSD);
        totalBalanceUsdRepository.save(totalBalanceUsd);

        return result;
    }

 
    private double calculateFeePercentage(double amount) {
        if (amount <= 500) {
            return 0.035; // 3.5%
        } else if (amount <= 1500) {
            return 0.027; // 2.7%
        } else if (amount <= 2500) {
            return 0.02; // 2.0%
        } else {
            return 0.015; // 1.5%
        }
    }
}



