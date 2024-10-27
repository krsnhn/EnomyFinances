package com.secnanifymone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.secnanifymone.models.Transaction;
import com.secnanifymone.services.TransactionService;

@Controller
public class TransactionController {

 @Autowired
 private TransactionService transactionService;

 @GetMapping("/transaction-history")
 public String showTransactionHistory(Model model) {
     List<Transaction> transactions = transactionService.getTransactionHistory();
     model.addAttribute("transactions", transactions);
     return "transaction-history";
 }
}
