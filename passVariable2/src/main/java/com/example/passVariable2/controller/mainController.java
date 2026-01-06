package com.example.passVariable2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class mainController {

    @GetMapping("/home")
    public String home(Model model) {
        String movieTitle = "Aavesham";
        model.addAttribute("movieTitle", movieTitle);
        String firstLine = "3 college students in a new city tries to take revenge on their bullies";
        model.addAttribute("firstLine", firstLine);
        String restLines = ". They befriends a gangster to hit back the bullies, but their college life changed forever.";
        model.addAttribute("restLines", restLines);
        boolean isLoggedIn = false;
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "home";
    }
}