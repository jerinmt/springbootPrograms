package com.example.formsproject1.controller;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class FormController{
//
//    @GetMapping("/form")
//    public String processForm(@RequestParam(required = false) String name, @RequestParam(required = false) String email, Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("email", email); 
//        return "userDetails";	
//    }
//
//    @PostMapping("/submit")
//    public String handleFormSubmission(@RequestParam String name, @RequestParam String email,Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("email", email); 
//        return "success";
//    }
//}

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import com.example.formsproject1.UserDetails;

@Controller
public class FormController {

    @GetMapping("/form")
    public String processForm(Model model) {
        UserDetails userDetails = new UserDetails();
        model.addAttribute("userDetails", userDetails);
        return "userDetails";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute UserDetails userDetails, BindingResult result, Model model) {
        model.addAttribute("userDetails", userDetails);
        if (result.hasErrors()) {
            return "userDetails";
        } else {
            return "success";
        }
    }
}
