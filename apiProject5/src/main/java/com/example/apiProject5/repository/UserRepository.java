package com.example.apiProject5.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiProject5.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByToken(String token);
    boolean existsByToken(String token);
}