package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent intent = getIntent();
        double monthlyBud = intent.getDoubleExtra("budget value", 0);
        double spent = intent.getDoubleExtra("spent value", 0);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.monthlyBudget);
        textView.setText("$" + Double.toString(monthlyBud));

        TextView textview2 = findViewById(R.id.monthlySpent);
        textview2.setText("$"+ Double.toString(spent));

    }
    public void changeBudget(View view) {
        Intent intent = new Intent(this, editBudget.class);
        startActivity(intent);
    }
    public void addTransaction(View view) {
        Intent intent = new Intent(this, newTransaction.class);
        startActivity(intent);
    }public void showTransactions(View view) {
        Intent intent = new Intent(this, viewTransactions.class);
        startActivity(intent);
    }
}