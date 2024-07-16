package com.example.reciclajeapp.models;

public class User {

    public String name;
    public String Surname;
    public String imageProfile;
    public String email;
    public String password;
    public String gender;
    public int    age;

    public User(){
       this.name         = "";
       this.Surname      = "";
       this.imageProfile = "";
       this.email        = "";
       this.password     = "";
       this.gender       = "";
       this.age          = 0;

    }

    public  User(String name, String Surname, String imageProfile, String email, String password, String gender, int age) {
        this.name           = name;
        this.Surname        = Surname;
        this.imageProfile   = imageProfile;
        this.email          = email;
        this.password       = password;
        this.gender         = gender;
        this.age            = age;

    }


    }