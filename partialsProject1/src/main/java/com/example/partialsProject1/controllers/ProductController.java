package com.example.partialsProject1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class ProductController {

    @GetMapping("/products")
    public String products() {
        return "productList";
    }
}