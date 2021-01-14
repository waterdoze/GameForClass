package com.example.gameforclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class TheGameplay extends AppCompatActivity {

    private int difficulty = 0; //EASY = 1; MEDIUM = 2; HARD = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_gameplay);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent i = getIntent();
        difficulty = i.getIntExtra("difficulty", 0); //If data not received, 0 is returned

    }


}