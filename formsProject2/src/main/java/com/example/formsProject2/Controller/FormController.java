package com.example.formsProject2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import com.example.formsProject2.UserDetails;

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
        if (result.hasErrors()) {
        	model.addAttribute("userDetails", userDetails);
            return "userDetails";
        } else {
            return "success";
        }
    }
}
