package com.secnanifymone.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secnanifymone.models.Expense;
import com.secnanifymone.models.MyUser;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findTop10ByUserOrderByDateDesc(MyUser user, Pageable pageable);

	List<Expense> findByUser(MyUser user);

	@Query("SELECT COALESCE(SUM(e.sum), 0) FROM Expense e WHERE e.user = :user AND e.category.name = :categoryName")
	double calculateCategoryExpense(@Param("user") MyUser user, @Param("categoryName") String categoryName);

}
