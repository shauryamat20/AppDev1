package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class viewTransactions extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transactions);

        Intent listTransactions = getIntent();
        User myUser = listTransactions.getParcelableExtra("my user");
        ArrayList<Transaction> myTransactions = myUser.getTransactions();
        String[] seller = new String[myTransactions.size()];
        String[] notes = new String[myTransactions.size()];
        Double[] amounts = new Double[myTransactions.size()];

        for(int i = 0; i<myTransactions.size(); i++){
            seller[i] = myTransactions.get(i).getName();
            notes[i] = myTransactions.get(i).getNote();
            amounts[i] = myTransactions.get(i).getAmount();
        }

        CustomListAdapter whatever = new CustomListAdapter(this, seller, notes, amounts);
        listView = (ListView) findViewById(R.id.listViewId);
        listView.setAdapter(whatever);

    }

    public void returnToHome(View view){
        finish();
    }
}