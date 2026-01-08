package com.example.partialsProject2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class IndexController {

    @GetMapping("/home")
    public String index() {
        return "index";
    }
    @GetMapping("/books")
    public String books() {
        return "books";
    }
}