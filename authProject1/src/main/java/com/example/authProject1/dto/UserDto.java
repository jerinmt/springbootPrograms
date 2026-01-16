package com.example.authProject1.dto;

public class UserDto {
   
    private String email;
    private String password;
    private String fullname;
    private String mobileNum;
   
    public UserDto(String email, String password, String fullname, String mobileNum) {
        super();
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.mobileNum = mobileNum;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   
    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}