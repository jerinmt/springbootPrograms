package com.example.authProject3.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authProject3.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}