package com.example.apiProject4.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiProject4.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}