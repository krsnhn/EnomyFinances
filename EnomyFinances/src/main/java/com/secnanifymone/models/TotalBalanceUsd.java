package com.secnanifymone.models;

import javax.persistence.*;

@Entity
@Table(name = "total_balance_usd")
public class TotalBalanceUsd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "amount")
    private Double amount;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

    // Constructors, getters, and setters
}
