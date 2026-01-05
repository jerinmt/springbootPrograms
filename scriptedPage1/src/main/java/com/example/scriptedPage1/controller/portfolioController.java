package com.example.scriptedPage1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class portfolioController {

    @GetMapping("/start")
    public String start() {
        return "redirect:/portfolio";
    }
	
    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }
}