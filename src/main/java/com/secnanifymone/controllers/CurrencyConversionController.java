package com.secnanifymone.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secnanifymone.models.MyUser;
import com.secnanifymone.models.UserCurrencyBalance;
import com.secnanifymone.repositories.UserCurrencyBalanceRepository;
import com.secnanifymone.services.CurrencyConversionService;
import com.secnanifymone.services.UserService;

@Controller
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService conversionService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserCurrencyBalanceRepository userCurrencyBalanceRepository;

	@PostMapping("/convert")
	public String convertCurrency(@RequestParam("fromCurrency") String fromCurrency,
			@RequestParam("toCurrency") String toCurrency, @RequestParam("amount") Double amount, Model model) {

		// Convert currency
		Double result = conversionService.convertCurrency(fromCurrency, toCurrency, amount);

		if (result != null) {
			// Update user balances
			userService.updateBalances(fromCurrency, toCurrency, amount);

			// Add converted result to model
			model.addAttribute("result", result);
		} else {
			// Handle conversion failure
			model.addAttribute("error", "Conversion failed. Please try again.");
		}
		model.addAttribute("result", result);
		return "redirect:/convert-currency";
	}

	@GetMapping("/convert-currency")
	public String showConvertCurrencyPage(@RequestParam(name = "result", required = false) Double result, Model model,
			Authentication authentication) {
		MyUser currentUser = userService.getCurrentUser();

		// Pass user's details to the view
		model.addAttribute("firstName", currentUser.getFirstName());
		model.addAttribute("lastName", currentUser.getLastName());
		Map<String, Double> balances = new HashMap<>();
		if (currentUser != null) {
			List<UserCurrencyBalance> currencyBalances = userCurrencyBalanceRepository
					.findByUserId(currentUser.getUserId());
			for (UserCurrencyBalance balance : currencyBalances) {
				balances.put(balance.getCurrency(), balance.getBalance());
			}
		}
		model.addAttribute("balances", balances);
		model.addAttribute("result", result != null ? result : 0.0); // Set initial result to the value from the URL
																		// parameter or 0 if not present
		return "convert-currency";
	}

}
