package com.example.androidappdev1;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private double budget;

    public User(String first, String last, String name, String pass){
        firstName = first;
        lastName = last;
        userName = name;
        password = pass;
        budget = 0;
    }
    public double getBudget(){
        return budget;
    }
    public void setBudget(double budget){
        this.budget = budget;
    }

}
