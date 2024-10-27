package com.secnanifymone.models;

import javax.persistence.*;

@Entity
@Table(name = "savings_investments")
public class SavingsInvestments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investmentId")
    private Long investmentId;

    @Column(name = "initialLumpSum")
    private Double initialLumpSum;

    @Column(name = "monthlyAmount")
    private Double monthlyAmount;

    @Column(name = "investmentType")
    private String investmentType;

    @Column(name = "maxReturns1Year")
    private Double maxReturns1Year;

    @Column(name = "minReturns1Year")
    private Double minReturns1Year;

    @Column(name = "maxReturns5Years")
    private Double maxReturns5Years;

    @Column(name = "minReturns5Years")
    private Double minReturns5Years;

    @Column(name = "maxReturns10Years")
    private Double maxReturns10Years;

    @Column(name = "minReturns10Years")
    private Double minReturns10Years;

    // You may add more attributes as needed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

    // Constructors, getters, and setters

    // Default constructor
    public SavingsInvestments() {
    }

    // Constructor with relevant fields
    public SavingsInvestments(Double initialLumpSum, Double monthlyAmount, String investmentType, MyUser user) {
        this.initialLumpSum = initialLumpSum;
        this.monthlyAmount = monthlyAmount;
        this.investmentType = investmentType;
        this.user = user;
    }

    // Getters and setters

    public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
    }

    public Double getInitialLumpSum() {
        return initialLumpSum;
    }

    public void setInitialLumpSum(Double initialLumpSum) {
        this.initialLumpSum = initialLumpSum;
    }

    public Double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(Double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public Double getMaxReturns1Year() {
        return maxReturns1Year;
    }

    public void setMaxReturns1Year(Double maxReturns1Year) {
        this.maxReturns1Year = maxReturns1Year;
    }

    public Double getMinReturns1Year() {
        return minReturns1Year;
    }

    public void setMinReturns1Year(Double minReturns1Year) {
        this.minReturns1Year = minReturns1Year;
    }

    public Double getMaxReturns5Years() {
        return maxReturns5Years;
    }

    public void setMaxReturns5Years(Double maxReturns5Years) {
        this.maxReturns5Years = maxReturns5Years;
    }

    public Double getMinReturns5Years() {
        return minReturns5Years;
    }

    public void setMinReturns5Years(Double minReturns5Years) {
        this.minReturns5Years = minReturns5Years;
    }

    public Double getMaxReturns10Years() {
        return maxReturns10Years;
    }

    public void setMaxReturns10Years(Double maxReturns10Years) {
        this.maxReturns10Years = maxReturns10Years;
    }

    public Double getMinReturns10Years() {
        return minReturns10Years;
    }

    public void setMinReturns10Years(Double minReturns10Years) {
        this.minReturns10Years = minReturns10Years;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
