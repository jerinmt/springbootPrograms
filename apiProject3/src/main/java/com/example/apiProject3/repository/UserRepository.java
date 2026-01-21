package com.example.apiProject3.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiProject3.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}