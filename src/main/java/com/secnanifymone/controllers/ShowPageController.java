package com.secnanifymone.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowPageController {

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/signup_error")
	public String showSignupFormError() {
		return "signup"; //
	}

	@GetMapping("/signup")
	public String showSignupForm() {
		return "signup"; //
	}

	@GetMapping("/contact-us")
	public String showContactUs() {
		return "contact-us"; //
	}
	@GetMapping("/savings_investments_form")
	public String showSavingsInvestment() {
		return "savings_investments_form"; //
	}
}

