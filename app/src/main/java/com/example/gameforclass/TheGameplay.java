package com.example.gameforclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

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
    public void openTab(View v){//If the expand button is pressed, this is called. Animation will be added soon
        ImageButton bruh = (ImageButton)v;//Could be removed?
        v.setVisibility(View.INVISIBLE);
        ScrollView SideBar = findViewById(R.id.SideBar);            //Will have to reorganize to have instantiation at the beginning of the method
        ScrollView BigSideBar = findViewById(R.id.BigSideBar);
        ImageButton BigTabButton = findViewById(R.id.BigTabButton);
        SideBar.setVisibility(View.INVISIBLE);
        BigSideBar.setVisibility(View.VISIBLE);
        BigTabButton.setVisibility(View.VISIBLE);
    }
    public void closeTab(View v){
        ImageButton bigTab = (ImageButton)v;
        v.setVisibility(View.INVISIBLE);
        ScrollView SideBar = findViewById(R.id.SideBar);
        ScrollView BigSideBar = findViewById(R.id.BigSideBar);
        ImageButton BigTabButton = findViewById(R.id.BigTabButton);
        SideBar.setVisibility(View.VISIBLE);
        BigSideBar.setVisibility(View.INVISIBLE);
        BigTabButton.setVisibility(View.INVISIBLE);
    }
}