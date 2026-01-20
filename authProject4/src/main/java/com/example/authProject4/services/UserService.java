package com.example.authProject4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authProject4.dto.UserDto;
import com.example.authProject4.models.Users;
import com.example.authProject4.repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    public Users save(UserDto userDto) {
        Users user = new Users(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getFirstname(), userDto.getLastname(), userDto.getAddress());
        return userRepository.save(user);
    }
}