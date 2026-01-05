package com.example.scriptedPage2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @GetMapping("/start")
    public String start() {
        return "redirect:/welcome";
    }
	
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}