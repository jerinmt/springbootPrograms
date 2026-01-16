package com.example.authProject1.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authProject1.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}