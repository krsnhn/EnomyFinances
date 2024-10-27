package com.secnanifymone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.secnanifymone.models.SavingsInvestments;
import com.secnanifymone.services.SavingsInvestmentsService;

@Controller
public class SavingsInvestmentsController {

    private final SavingsInvestmentsService savingsInvestmentsService;

    public SavingsInvestmentsController(SavingsInvestmentsService savingsInvestmentsService) {
        this.savingsInvestmentsService = savingsInvestmentsService;
    }

    @GetMapping("/savings-investments")
    public String showForm(Model model) {
        model.addAttribute("savingsInvestments", new SavingsInvestments());
        return "savings_investments_form"; // The JSP page for the form
    }

    @PostMapping("/savings-investments")
    public String calculateReturns(SavingsInvestments savingsInvestments, Model model) {
        SavingsInvestments calculatedInvestments = savingsInvestmentsService.calculateReturns(savingsInvestments);
        model.addAttribute("calculatedInvestments", calculatedInvestments);
        return "savings_investments_form"; // The JSP page for displaying results
    }
}
