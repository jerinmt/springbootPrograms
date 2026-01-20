package com.example.authProject3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users3", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Users {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String email;
    private String password;
    private String fullname;
    private String mobileNum;

    public Users() {
        super();
    }

    public Users(String email, String password, String fullname, String mobileNum) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.mobileNum = mobileNum;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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