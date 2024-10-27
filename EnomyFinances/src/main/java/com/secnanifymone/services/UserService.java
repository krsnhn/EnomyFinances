package com.secnanifymone.services;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.secnanifymone.models.MyUser;

public interface UserService {
    void registerNewClient(String firstName, String lastName, String email, String password,String confirmPassword);

	boolean emailExists(String email);
	
	void setPasswordEncoder(PasswordEncoder passwordEncoder);

	MyUser getCurrentUser();
	
	void updateBalances(String fromCurrency, String toCurrency, Double amount);
	
}