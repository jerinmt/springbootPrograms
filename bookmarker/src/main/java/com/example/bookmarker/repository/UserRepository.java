package com.example.bookmarker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bookmarker.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	@Query("SELECT p FROM Users p WHERE p.username=:username")
	Users findByUsername(String username);
}