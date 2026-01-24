package com.example.fileProject1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender sender;

    
    // Send email with product details
    @GetMapping("/email")
    @ResponseBody
    public String sendEmail() {
        try {
            
            // Prepare the email content
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("receiver@mailtrap.io");  // Replace with your Mailtrap address or receiver's email
            msg.setSubject("File received");
            msg.setText("File received successfully");
                    
            // Send the email
            sender.send(msg);
            return "Successfully sent email";
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return "Sending email failed";
        }
    }
}