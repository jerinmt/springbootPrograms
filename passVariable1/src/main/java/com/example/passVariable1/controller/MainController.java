package com.example.passVariable1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {

   
    @GetMapping("/home")
    public String home(Model model) {
        String message = "Education is the most powerful weapon which you can use to change the world.";
        model.addAttribute("message", message);
        String welcome = "<h1>Welcome to Star institute</h1>";
        model.addAttribute("welcome", welcome);
        boolean isLoggedIn = false;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "home";
    }
}