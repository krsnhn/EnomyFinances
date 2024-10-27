package com.secnanifymone.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secnanifymone.models.Category;
import com.secnanifymone.models.Expense;
import com.secnanifymone.repositories.CategoryRepository; // Import CategoryRepository
import com.secnanifymone.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private CategoryRepository categoryRepository; // Autowire CategoryRepository

	@PostMapping("/addExpense")
	public String addExpense(@RequestParam String purpose, @RequestParam double sum, @RequestParam String date,
			@RequestParam String category) {
		// Convert date string to LocalDate
		LocalDate expenseDate = LocalDate.parse(date);

		// Retrieve Category object by name
		Category expenseCategory = categoryRepository.findByName(category);

		// Create an Expense object
		Expense expense = new Expense();
		expense.setPurpose(purpose);
		expense.setSum(sum);
		expense.setDate(expenseDate);
		expense.setCategory(expenseCategory); // Set Category object

		// Add expense and update balances
		expenseService.addExpenseAndUpdateBalances(expense);

		// Redirect to a success page or another appropriate view
		return "redirect:/dashboard";
	}
}
