package com.example.androidappdev1;

public class Transaction {

    private String sellerName;
    private String note;
    private double amount;

    public Transaction(String sellerName, String note, double amount) {
        this.sellerName = sellerName;
        this.note = note;
        this.amount = amount;
    }

}
