package com.example.staticPage2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class ConcertController {

    @GetMapping("/concert")
    public String welcome() {
        return "Welcome";
    }
}