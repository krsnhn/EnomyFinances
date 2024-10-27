package com.secnanifymone.controllers;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class DashboardController {
//
//    @GetMapping("/dashboard")
//    public String dashboard(Model model, Authentication authentication) {
//        // Retrieve authenticated user's details
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        // Pass user's details to the view
//        model.addAttribute("firstName", userDetails.getFirstName());
//        model.addAttribute("lastName", userDetails.getLastName());
//        return "dashboard";
//    }
//}


import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.secnanifymone.models.TotalBalanceUsd;
import com.secnanifymone.models.Expense;
import com.secnanifymone.models.MyUser;
import com.secnanifymone.repositories.TotalBalanceUsdRepository;
import com.secnanifymone.repositories.ExpenseRepository;
import com.secnanifymone.repositories.UserRepository;
import com.secnanifymone.services.UserService;

@Controller
public class DashboardController {

    private final UserService userService;
    private final TotalBalanceUsdRepository totalBalanceUsdRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public DashboardController(UserRepository userRepository, UserService userService,
                               TotalBalanceUsdRepository totalBalanceUsdRepository, ExpenseRepository expenseRepository) {
        this.userService = userService;
        this.totalBalanceUsdRepository = totalBalanceUsdRepository;
        this.expenseRepository = expenseRepository;
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        // Retrieve authenticated user's details using UserService
        MyUser currentUser = userService.getCurrentUser();
        
        // Pass user's details to the view
        model.addAttribute("firstName", currentUser.getFirstName());
        model.addAttribute("lastName", currentUser.getLastName());

        // Retrieve user's balance
        TotalBalanceUsd totalBalanceUsd = totalBalanceUsdRepository.findByUser(currentUser);
        double formattedBalance = formatToTwoDecimalPlaces(totalBalanceUsd.getAmount());
        model.addAttribute("balance", formattedBalance);

        // Retrieve and calculate category balances
        double foodsDrinksExpense = expenseRepository.calculateCategoryExpense(currentUser, "Foods and Drinks");
        double billsUtilitiesExpense = expenseRepository.calculateCategoryExpense(currentUser, "Bills and Utilities");
        double othersExpense = expenseRepository.calculateCategoryExpense(currentUser, "Others");

        // Pass category balances to the view
        model.addAttribute("foodsDrinksExpense", formatToTwoDecimalPlaces(foodsDrinksExpense));
        model.addAttribute("billsUtilitiesExpense", formatToTwoDecimalPlaces(billsUtilitiesExpense));
        model.addAttribute("othersExpense", formatToTwoDecimalPlaces(othersExpense));
        
        // Retrieve recent transactions for the user
        Pageable pageable = PageRequest.of(0, 15); // Get first 10 records
        List<Expense> recentPurchases = expenseRepository.findTop10ByUserOrderByDateDesc(currentUser, pageable);
        
     // Print recent purchases details
        for (Expense purchase : recentPurchases) {
            System.out.println("Purpose: " + purchase.getPurpose());
            System.out.println("Sum: " + purchase.getSum());
            System.out.println("Category: " + purchase.getCategory().getName());
            System.out.println("Date: " + purchase.getDate());
            System.out.println("-------------------------");
        }
        
        // Pass recent transactions to the view
        model.addAttribute("recentPurchases", recentPurchases);
        
        return "dashboard";
    }

    // Method to format a double to two decimal places
    private double formatToTwoDecimalPlaces(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }
    
}


