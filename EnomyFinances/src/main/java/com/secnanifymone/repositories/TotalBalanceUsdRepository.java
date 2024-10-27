package com.secnanifymone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secnanifymone.models.TotalBalanceUsd;
import com.secnanifymone.models.MyUser;

public interface TotalBalanceUsdRepository extends JpaRepository<TotalBalanceUsd, Long> {

	TotalBalanceUsd findByUser(MyUser currentUser);
    // Add custom query methods if needed

	
}
