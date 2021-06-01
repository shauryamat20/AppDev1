package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Intent intent = getIntent();
        User myUser = intent.getParcelableExtra("my user");
        myUser.addSpent(10);
        Log.d("TEST2", Double.toString(myUser.getBudget()));
        //Log.d("TEST3", myUser.getFirstName());
        //double monthlyBud = intent.getDoubleExtra("budget value", 0);
        //double spent = intent.getDoubleExtra("spent value", 0);
        //double remainder = intent.getDoubleExtra("remaining value", 0);
        double monthlyBud = myUser.getBudget();
        double spent = myUser.getSpent();
        double remainder = myUser.getRemaining();


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.monthlyBudget);
        textView.setText("$" + Double.toString(monthlyBud));

        TextView textview2 = findViewById(R.id.monthlySpent);
        textview2.setText("$"+ Double.toString(spent));

        TextView textview3 = findViewById(R.id.monthyRemain);
        textview3.setText("$"+ Double.toString(remainder));

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