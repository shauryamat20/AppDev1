package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class newTransaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);
    }
    public void addTransactionMethod(View view){
        Intent addingTransaction = getIntent();
        User myUser = addingTransaction.getParcelableExtra("my user");
        EditText seller = (EditText)findViewById(R.id.sellerName);
        EditText note = (EditText)findViewById(R.id.transactionNote);
        EditText amount = (EditText)findViewById(R.id.transactionAmount);

        String sellerName = seller.getText().toString();
        String sellNote = note.getText().toString();
        double sellAmount = Double.parseDouble(amount.getText().toString());

        Transaction toAdd = new Transaction(sellerName, sellNote, sellAmount);
        //Log.d("Test7", Double.toString(toAdd.getAmount()));

        myUser.addTransaction(toAdd);

        //Log.d("Test8", Double.toString(myUser.getSpent()));

        Intent returnToHome = new Intent(this, homeScreen.class);
        returnToHome.putExtra("my user", myUser);
        //Log.d("Test9", Double.toString(myUser.getSpent()));
        //Log.d("Test10", myUser.getTransactions().get(0).getName());
        startActivity(returnToHome);


    }
}