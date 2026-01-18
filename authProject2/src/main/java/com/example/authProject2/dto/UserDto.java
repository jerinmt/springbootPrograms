package com.example.authProject2.dto;

public class UserDto {
   
    private String email;
    private String password;
    private String username;
    private String dob;
    private String address;
   
    public UserDto(String email, String password, String username, String dob, String address) {
        super();
        this.email = email;
        this.password = password;
        this.username = username;
        this.dob = dob;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}