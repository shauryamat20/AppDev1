package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class editBudget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_budget);

    }
    public void editBudgetMethod(View view){
        Intent changingBudget = getIntent();
        User myUser = changingBudget.getParcelableExtra("my user");
        //Log.d("Test4", Double.toString(myUser.getBudget()));
        EditText editText = (EditText)findViewById(R.id.newBudget);
        String message = editText.getText().toString();
        myUser.setBudget(Double.parseDouble(message));
        //Log.d("Test5", Double.toString(myUser.getBudget()));
        Intent returnIntent = new Intent(this, homeScreen.class);
        returnIntent.putExtra("my user", myUser);
        startActivity(returnIntent);
    }
}