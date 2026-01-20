package com.example.authProject4.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authProject4.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}