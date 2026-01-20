package com.example.authProject3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.authProject3.dto.UserDto;
import com.example.authProject3.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }
    
    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("name", userDto.getFullname());
        return "register";
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