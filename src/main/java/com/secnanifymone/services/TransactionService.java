package com.secnanifymone.services;

import java.util.List;
import com.secnanifymone.models.Transaction;

public interface TransactionService {
 List<Transaction> getTransactionHistory();
 void saveTransactionHistory(String fromCurrency, String toCurrency, Double amount, Double fee);
}
