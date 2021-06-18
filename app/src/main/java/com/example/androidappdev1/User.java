package com.example.androidappdev1;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

public class User implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private double budget;
    private double spent;
    private double remaining;
    private ArrayList<Transaction> transactions;

    public User(String first, String last, String name, String pass){
        firstName = first;
        lastName = last;
        userName = name;
        password = pass;
        budget = 0;
        spent = 0;
        remaining = budget-spent;
        transactions = new ArrayList<Transaction>();
    }

    public User(String firstName, String lastName, String userName, String password, double budget, double spent, double remaining, ArrayList<Transaction> transactions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.budget = budget;
        this.spent = spent;
        this.remaining = remaining;
        this.transactions = transactions;
    }

    public User(String firstName, String lastName, String userName, String password, double budget, double spent, double remaining) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.budget = budget;
        this.spent = spent;
        this.remaining = remaining;
    }

    public double getBudget(){
        return budget;
    }
    public void setBudget(double budget){
        this.budget = budget;
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

    public void addTransaction(Transaction t){
        transactions.add(t);
        this.addSpent(t.getAmount());
    }

    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }
    public User(Parcel in){
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.userName = in.readString();
        this.password = in.readString();
        this.budget = in.readDouble();
        this.spent = in.readDouble();
        this.remaining = in.readDouble();
        this.transactions = in.readArrayList(Transaction.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.userName);
        dest.writeString(this.password);
        dest.writeDouble(this.budget);
        dest.writeDouble(this.spent);
        dest.writeDouble(this.remaining);
        dest.writeList(this.transactions);
    }

}
