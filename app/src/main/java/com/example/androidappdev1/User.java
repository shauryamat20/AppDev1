package com.example.androidappdev1;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private double budget;
    private double spent;
    private double remaining;

    public User(String first, String last, String name, String pass){
        firstName = first;
        lastName = last;
        userName = name;
        password = pass;
        budget = 0;
        spent = 0;
        remaining = budget-spent;
    }
    public double getBudget(){
        return budget;
    }
    public void setBudget(double budget){
        this.budget = budget;
        this.spent = this.budget-this.spent;
        this.remaining = this.budget - this.spent;
    }
    public double getSpent(){
        return spent;
    }
    public void addSpent(double n){
        spent +=n;
        remaining -=n;
    }
    public double getRemaining(){
        return remaining;
    }
}
