package com.example.authProject2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authProject2.dto.UserDto;
import com.example.authProject2.models.Users;
import com.example.authProject2.repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    public Users save(UserDto userDto) {
        Users user = new Users(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getUsername(), userDto.getDOB(), userDto.getAddress());
        return userRepository.save(user);
    }
}