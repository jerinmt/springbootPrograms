package com.example.authProject4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.authProject4.dto.UserDto;
import com.example.authProject4.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }
    
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto) {
        userService.save(userDto);
        return "welcome";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/welcome")
    public String getWelcomePage() {
        return "welcome";
    }
}