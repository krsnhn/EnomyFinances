package com.secnanifymone.services;

import com.secnanifymone.models.Expense;

public interface ExpenseService {
    void addExpense(Expense expense);
    
    void addExpenseAndUpdateBalances(Expense expense);
}

