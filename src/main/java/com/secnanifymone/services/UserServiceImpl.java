package com.secnanifymone.services;

import com.secnanifymone.models.Role;
import com.secnanifymone.models.TotalBalanceUsd;
import com.secnanifymone.models.UserCurrencyBalance;
import com.secnanifymone.models.MyUser;
import com.secnanifymone.repositories.RoleRepository;
import com.secnanifymone.repositories.TotalBalanceUsdRepository;
import com.secnanifymone.repositories.UserCurrencyBalanceRepository;
import com.secnanifymone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final RoleRepository roleRepository;

	@Autowired
	private UserCurrencyBalanceRepository balanceRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Constructor injection or autowire the repository
	public UserServiceImpl(UserCurrencyBalanceRepository userCurrencyBalanceRepository, RoleRepository roleRepository) {
		this.roleRepository = roleRepository; // Initialize roleRepository
	}

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository; // Initialize roleRepository
	}

	@Autowired
	private TotalBalanceUsdRepository totalBalanceUsdRepository;
	
	// Method to list all users
	public List<MyUser> listAll() {
		return userRepository.findAll();
	}

	// Method to get a user by ID
	public MyUser get(Long id) {
		Optional<MyUser> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			throw new IllegalArgumentException("User not found with ID: " + id);
		}
	}

	// Method to delete a user by ID
	public void delete(Long userId) {
		userRepository.deleteByUserId(userId);
	}

	// Method to register a new client
	@Override
	public void registerNewClient(String firstName, String lastName, String email, String password, String confirmPassword) {
	    // Check if client with given email already exists
		if (emailExists(email)) {
		    throw new RuntimeException("Email already exists. Please use a different email address.");
		}


	    // Encode the password
	    String encodedPassword = passwordEncoder.encode(password);

	    // Capitalize the first letter of the first name and last name
	    firstName = capitalizeFirstLetter(firstName);
	    lastName = capitalizeFirstLetter(lastName);

	    // Create new user
	    MyUser myUser = new MyUser();
	    myUser.setFirstName(firstName);
	    myUser.setLastName(lastName);
	    myUser.setEmail(email);
	    myUser.setPassword(encodedPassword); // Store the encoded password

	    // Set the user role to "User"
	    Role userRole = roleRepository.findByRoleName("USER");
	    if (userRole == null) {
	        throw new RuntimeException("Role 'User' not found. Please make sure it exists in the database.");
	    } else {
	        myUser.setRoles(Collections.singleton(userRole));

	        // Save user to the database
	        userRepository.save(myUser);

	        // Add a balance of 50000 for the new user
	        TotalBalanceUsd initialBalance = new TotalBalanceUsd();
	        initialBalance.setUser(myUser); // Associate the user
	        initialBalance.setAmount(50000.0);
	        totalBalanceUsdRepository.save(initialBalance);

	        System.out.println(
	                "\nNew User Has Been Registered!" + "\nName: " + firstName + " " + lastName + "\nEmail: " + email);
	    }
	}



	// Method to check if email exists
	@Override
	public boolean emailExists(String email) {
		MyUser myUser = userRepository.findByEmail(email);
		return myUser != null; // Returns true if user is found, false otherwise
	}

	@Override
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		// TODO Auto-generated method stub

	}

	// Method to capitalize the first letter of a string
	private String capitalizeFirstLetter(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * Retrieves the currently logged-in user from the security context. If a user
	 * is logged in, their corresponding MyUser object is fetched from the
	 * repository based on the user's email obtained from the UserDetails. Returns
	 * null if no user is logged in or if user details cannot be retrieved.
	 * 
	 * @return The MyUser object of the currently logged-in user, or null if no user
	 *         is logged in.
	 */
	@Override
	public MyUser getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails) {
				String email = ((UserDetails) principal).getUsername();
				return userRepository.findByEmail(email);
			}
		}
		return null;
	}

	@Override
	public void updateBalances(String fromCurrency, String toCurrency, Double amount) {
		MyUser currentUser = getCurrentUser();
		if (currentUser != null) {
			// Find the balances for the current user
			UserCurrencyBalance fromBalance = balanceRepository.findByUserIdAndCurrency(currentUser.getUserId(),
					fromCurrency);
			UserCurrencyBalance toBalance = balanceRepository.findByUserIdAndCurrency(currentUser.getUserId(),
					toCurrency);

			if (fromBalance != null && toBalance != null) {
				// Deduct the amount from the "fromCurrency" balance
				fromBalance.setBalance(fromBalance.getBalance() - amount);

				// Add the converted amount to the "toCurrency" balance
				toBalance.setBalance(toBalance.getBalance() + amount);

				// Save updated balances
				balanceRepository.save(fromBalance);
				balanceRepository.save(toBalance);
			} else {
				// Handle balance not found
			}
		} else {
			// Handle current user not found
		}
	}

	@Override
	public List<MyUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	

}