package com.secnanifymone.models;

import javax.persistence.*;

@Entity
@Table(name = "user_currency_balance")
public class UserCurrencyBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "currency")
	private String currency;

	@Column(name = "balance", columnDefinition = "decimal(10,2)")
	private Double balance;

	@OneToOne(mappedBy = "user")
	private TotalBalanceUsd totalBalanceUsd;

	public TotalBalanceUsd getTotalBalanceUsd() {
		return totalBalanceUsd;
	}

	public void setTotalBalanceUsd(TotalBalanceUsd totalBalanceUsd) {
		this.totalBalanceUsd = totalBalanceUsd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	// Getters and setters
}
