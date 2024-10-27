package com.secnanifymone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secnanifymone.models.UserCurrencyBalance;

public interface UserCurrencyBalanceRepository extends JpaRepository<UserCurrencyBalance, Long> {
	UserCurrencyBalance findByUserIdAndCurrency(Long userId, String currency);

	List<UserCurrencyBalance> findByUserId(Long userId);

	// Define method to calculate total balance for a user and currency
	@Query("SELECT SUM(ucb.balance) FROM UserCurrencyBalance ucb WHERE ucb.userId = :userId AND ucb.currency = :currency")
	Double calculateTotalBalanceForUserAndCurrency(@Param("userId") Long userId, @Param("currency") String currency);

	void save(double newTotalBalanceUSD);
}
