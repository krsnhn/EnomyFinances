package com.secnanifymone.repositories;

import com.secnanifymone.models.MyUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
	
	@Query("SELECT u FROM MyUser u WHERE u.userId = :userId")
    Optional<MyUser> findById(@Param("userId") Long userId);
	
	MyUser findByEmail(String email);

	void deleteByUserId(Long userId);

	
}
