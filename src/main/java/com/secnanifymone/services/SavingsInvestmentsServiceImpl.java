package com.secnanifymone.services;

import org.springframework.stereotype.Service;

import com.secnanifymone.models.SavingsInvestments;

@Service
public class SavingsInvestmentsServiceImpl implements SavingsInvestmentsService {

    @Override
    public SavingsInvestments calculateReturns(SavingsInvestments savingsInvestments) {
        double annualRate = getAnnualRate(savingsInvestments.getInvestmentType());

        double maxReturns1Year = calculateMaxReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 1);
        double minReturns1Year = calculateMinReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 1);

        double maxReturns5Years = calculateMaxReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 5);
        double minReturns5Years = calculateMinReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 5);

        double maxReturns10Years = calculateMaxReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 10);
        double minReturns10Years = calculateMinReturns(savingsInvestments.getInitialLumpSum(),
                savingsInvestments.getMonthlyAmount(), annualRate, 10);

        savingsInvestments.setMaxReturns1Year(maxReturns1Year);
        savingsInvestments.setMinReturns1Year(minReturns1Year);

        savingsInvestments.setMaxReturns5Years(maxReturns5Years);
        savingsInvestments.setMinReturns5Years(minReturns5Years);

        savingsInvestments.setMaxReturns10Years(maxReturns10Years);
        savingsInvestments.setMinReturns10Years(minReturns10Years);

        return savingsInvestments;
    }

    private double getAnnualRate(String investmentType) {
        switch (investmentType) {
            case "Basic Savings Plan":
                return 0.012; // 1.2% annual rate
            case "Savings Plan Plus":
                return 0.03;  // 3% annual rate
            case "Managed Stock Investments":
                return 0.04;  // 4% annual rate
            default:
                return 0;
        }
    }

    private double calculateMaxReturns(double initialLumpSum, double monthlyAmount, double annualRate, int years) {
        return initialLumpSum + monthlyAmount * 12 * years * Math.pow(1 + annualRate, years);
    }

    private double calculateMinReturns(double initialLumpSum, double monthlyAmount, double annualRate, int years) {
        return initialLumpSum + monthlyAmount * 12 * Math.pow(1 + annualRate, years);
    }
}
