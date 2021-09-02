package com.example.newproject;

public class User {
    public String Name;
    public String Email;
    public String Password ;


    public User(){

    }
    public User(String name, String email, String password) {
        this.Name = name;
        Email = email;
        Password = password;
    }






    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
