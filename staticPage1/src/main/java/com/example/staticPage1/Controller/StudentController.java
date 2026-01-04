package com.example.staticPage1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class StudentController {

    @GetMapping("/student")
    public String hello() {
        return "Hello";
    }
}