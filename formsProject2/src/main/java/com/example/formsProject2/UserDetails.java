package com.example.formsProject2;

import jakarta.validation.constraints.NotBlank;

public class UserDetails {

    @NotBlank(message = "Name is required")
    public String name;
    
    @NotBlank(message = "Email address is required")
    @GmailOnly(message = "Email address should be from Gmail")
    public String email;
    
    @NotBlank(message = "Address is required")
    @Address(message = "Your address must contain India")
    public String address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
    	this.address=address;
    }
}
