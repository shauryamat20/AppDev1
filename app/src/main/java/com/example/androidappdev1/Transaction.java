package com.example.androidappdev1;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };

    private String sellerName;
    private String note;
    private double amount;

    public Transaction(String sellerName, String note, double amount) {
        this.sellerName = sellerName;
        this.note = note;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getName(){
        return this.sellerName;
    }

    public Transaction(Parcel in){
        this.sellerName = in.readString();
        this.note = in.readString();
        this.amount = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sellerName);
        dest.writeString(this.note);
        dest.writeDouble(this.amount);

    }
}
