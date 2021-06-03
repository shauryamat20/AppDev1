package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class viewTransactions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        Intent listTransactions = getIntent();
        User myUser = listTransactions.getParcelableExtra("my user");
        ArrayList<Transaction> myTransactions = myUser.getTransactions();
    }
}