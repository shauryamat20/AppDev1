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
        Log.d("Recieved Budget", Double.toString(myUser.getBudget()));
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
        Intent intentFirst = getIntent();
        User myUser = intentFirst.getParcelableExtra("my user");
        //Log.d("Test3", Double.toString(myUser.getBudget()));
        Intent changingBudget = new Intent(this, editBudget.class);
        changingBudget.putExtra("my user", myUser);
        startActivity(changingBudget);
    }
    public void addTransaction(View view) {
        Intent intentFirst = getIntent();
        User myUser = intentFirst.getParcelableExtra("my user");

        Intent addingTransaction = new Intent(this, newTransaction.class);
        addingTransaction.putExtra("my user", myUser);
        startActivity(addingTransaction);
    }public void showTransactions(View view) {
        Intent intent = new Intent(this, viewTransactions.class);
        startActivity(intent);
    }
}