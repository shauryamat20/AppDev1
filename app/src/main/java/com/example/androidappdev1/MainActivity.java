package com.example.androidappdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signIn(View view) {
        Intent intent = new Intent(this, homeScreen.class);
        User trial = new User("Shaurya", "Mathur", "shauryamat", "password");
        trial.setBudget(30);
        //        intent.putExtra("spent value", trial.getSpent());
  //      intent.putExtra("budget value",trial.getBudget());
    //    intent.putExtra("remaining value", trial.getRemaining());
        //Log.d("Sent Budget", Double.toString(trial.getBudget()));
        intent.putExtra("my user", trial);
        startActivity(intent);
    }
    public void signUp(View view) {
        Intent intent = new Intent(this, signUpScreen.class);
        startActivity(intent);
    }
}