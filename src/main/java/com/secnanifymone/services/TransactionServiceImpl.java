package com.secnanifymone.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secnanifymone.models.MyUser;
import com.secnanifymone.models.Transaction;
import com.secnanifymone.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

 @Autowired
 private UserService userService;

 @Autowired
 private TransactionRepository transactionRepository;

 @Override
 public List<Transaction> getTransactionHistory() {
     MyUser currentUser = userService.getCurrentUser();
     return transactionRepository.findAllByUser(currentUser);
 }

 @Override
 public void saveTransactionHistory(String fromCurrency, String toCurrency, Double amount, Double fee) {
     MyUser currentUser = userService.getCurrentUser();

     Transaction transaction = new Transaction();
     transaction.setUser(currentUser);
     transaction.setFromCurrency(fromCurrency);
     transaction.setToCurrency(toCurrency);
     transaction.setAmount(amount);
     transaction.setFee(fee);

     // Save the transaction history
     transactionRepository.save(transaction);
 }
}
