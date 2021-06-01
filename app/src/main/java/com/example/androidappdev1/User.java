package com.example.androidappdev1;

import android.os.Parcel;
import android.os.Parcelable;

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
    public String getFirstName(){
        return this.firstName;
    }
    public void setBudget(double budget){
        this.budget = budget;
        this.spent = this.spent;
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
    public User(Parcel in){
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.userName = in.readString();
        this.password = in.readString();
        this.budget = in.readDouble();
        this.spent = in.readDouble();
        this.remaining = in.readDouble();
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
    }

}
