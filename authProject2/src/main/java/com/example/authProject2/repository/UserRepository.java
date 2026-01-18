package com.example.authProject2.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authProject2.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}