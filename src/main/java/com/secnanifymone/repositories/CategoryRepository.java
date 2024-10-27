package com.secnanifymone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secnanifymone.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String category);
	// Add custom query methods if needed
}
