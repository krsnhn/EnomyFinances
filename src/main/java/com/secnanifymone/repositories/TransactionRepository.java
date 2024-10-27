package com.secnanifymone.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secnanifymone.models.MyUser;
import com.secnanifymone.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
 List<Transaction> findAllByUser(MyUser user);
}
