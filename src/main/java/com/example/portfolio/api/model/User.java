package com.example.portfolio.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Autowired
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private int number;


   public User(Long id, String fullname, String username, String password, String email, int number){
       this.id = id;
       this.username = username;
       this.fullname = fullname;
       this.password = password;
       this.email = email;
       this.number = number;
   }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public int getUsername(){
        return username;
    }
    public void setUsername(int username){
        this.username = username;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public int getPassword(){
        return password;
    }
    public void setPassword(int password){
        this.number = password;
    }

    // ... other fields like 'role' if you wish to differentiate user types
    // ... getters, setters, etc.
}
