package com.example.gameforclass.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;
import com.example.gameforclass.TowerType;
import com.example.gameforclass.cells.Tower;

import org.w3c.dom.Text;

public class TheGameplay extends AppCompatActivity {

    private int difficulty = 0; //EASY = 1; MEDIUM = 2; HARD = 3;

    //TheGameplay is the activity in which the GameFragment class runs in

    TowerDefensePog game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent i = getIntent();
        difficulty = i.getIntExtra("difficulty", 0); //If data not received, 0 is returned

        setContentView(R.layout.activity_the_gameplay); //Use the layout file to organize the screen

         game = (TowerDefensePog) findViewById(R.id.gameFragment);
    }

    //SETVISIBILITY VALUES: 0 == VISIBLE      4 == INVISIBLE      8 == GONE
    @SuppressLint("WrongConstant")//Allows the setVisibility to take values other than the constants
    public void changeSideBar(View v){//If the expand button is pressed, this is called. Animation will be added soon
        ScrollView SideBar = findViewById(R.id.SideBar);
        ScrollView BigSideBar = findViewById(R.id.BigSideBar);
        ImageButton SmallTabButton = findViewById(R.id.SmallTabButton);
        ImageButton BigTabButton = findViewById(R.id.BigTabButton);

        int setBig = 0; int setSmall = 8;
        if(v.getId() == R.id.BigTabButton){//if this is the big tab button we pressed, then we want to make the big ones disappear
            setBig = 8;
            setSmall = 0;
        }
        SmallTabButton.setVisibility(setSmall);//Gone == invisible but on steroids because it won't affect layout or be treated as existing when it's set to gone
        SideBar.setVisibility(setSmall);
        BigSideBar.setVisibility(setBig);
        BigTabButton.setVisibility(setBig);
    }

    public void neutroButton(View v) {

        game.setTowerPlacementMode(TowerType.NEUTROPHIL);
    }

    public void changeText(int playerHP, int bio, int round)
    {
        runOnUiThread(new Runnable() { //can't edit UI text from the game logic thread, have to switch to the UI thread
            @Override
            public void run() {
                ((TextView)findViewById(R.id.PlayerHealth)).setText(String.format("Health: %d/100", playerHP));
                ((TextView)findViewById(R.id.BiomoleculeCounter)).setText(String.format("BM: %d", bio));
                ((TextView)findViewById(R.id.RoundCounter)).setText(String.format("Round: %d", round));

            }
        });

    }


}