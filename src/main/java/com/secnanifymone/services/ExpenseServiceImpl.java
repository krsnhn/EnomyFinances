package com.secnanifymone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.secnanifymone.models.TotalBalanceUsd;
import com.secnanifymone.models.Expense;
import com.secnanifymone.models.MyUser;
import com.secnanifymone.repositories.TotalBalanceUsdRepository;
import com.secnanifymone.repositories.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private TotalBalanceUsdRepository totalBalanceUsdRepository;

	@Autowired
	private UserServiceImpl userService;

	@Override
	@Transactional
	public void addExpense(Expense expense) {
		// Save the expense
		expenseRepository.save(expense);
	}

	@Override
	@Transactional
	public void addExpenseAndUpdateBalances(Expense expense) {
		System.out.println("I'm in addExpenseAndUpdateBalances");
		MyUser currentUser = userService.getCurrentUser();

		expense.setUser(currentUser);

		// Use currentUser instead of trying to get the user from the expense object
		TotalBalanceUsd totalBalanceUsd = currentUser.getBalance();
		Double currentBalance = totalBalanceUsd.getAmount();

		// Deduct expense from user's balance
		Double updatedBalance = currentBalance - expense.getSum();
		totalBalanceUsd.setAmount(updatedBalance);

		// Update user's balance in the database
		totalBalanceUsdRepository.save(totalBalanceUsd);

		// Save the expense
		expenseRepository.save(expense);
	}

}
