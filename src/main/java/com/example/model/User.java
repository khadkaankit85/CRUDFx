package com.example.model;

public class User {
    String username;
    String password;


    public  User(String username, String password){
        this.username=username;
        this.password=password;

    }
    public User(String username){
        this(username,"");
    }

    public String getPassword() {
        return this.password;
    }
    public String getUsername(){
        return  this.username;
    }
}
