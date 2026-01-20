package com.example.authProject3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authProject3.dto.UserDto;
import com.example.authProject3.models.Users;
import com.example.authProject3.repository.UserRepository;

@Service
public class UserService{
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    public Users save(UserDto userDto) {
        Users user = new Users(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getFullname(), userDto.getMobileNum());
        return userRepository.save(user);
    }
}