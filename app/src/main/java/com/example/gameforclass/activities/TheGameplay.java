package com.example.gameforclass.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;
import com.example.gameforclass.cells.TowerType;
import com.example.gameforclass.cells.UpgradeType;

public class TheGameplay extends AppCompatActivity {

    private int difficulty = 0; //EASY = 1; MEDIUM = 2; HARD = 3;

    //TheGameplay is the activity in which the GameFragment class runs in

    TowerDefensePog game;

    private boolean sideBarisBig = false;
    private boolean animationEnded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent i = getIntent();
        difficulty = i.getIntExtra("difficulty", 0); //If data not received, 0 is returned

        setContentView(R.layout.activity_the_gameplay); //Use the layout file to organize the screen


        game = (TowerDefensePog) findViewById(R.id.gameFragment);


//
//        AnimatorSet invisAnim = new AnimatorSet();
//        invisAnim.setDuration(50);
//        invisAnim.playTogether(
//                ObjectAnimator.ofFloat(findViewById(R.id.UpgradeSideBar), "translationX", 350f),
//                ObjectAnimator.ofFloat(findViewById(R.id.UpgradeTabButton), "translationX", 350f)
//        );
//        invisAnim.start();
    }


    //SETVISIBILITY VALUES: 0 == VISIBLE      4 == INVISIBLE      8 == GONE
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")//Allows the setVisibility to take values other than the constants
    public void changeSideBar(View v){//If the expand button is pressed, this is called. Animation will be added soon
        animationEnded = false;
        ScrollView SideBar = findViewById(R.id.SideBar);
        ScrollView BigSideBar = findViewById(R.id.UpgradeSideBar);

        ImageButton SmallTabButton = findViewById(R.id.TabButton);
        ImageButton BigTabButton = findViewById(R.id.UpgradeTabButton);

        AnimatorSet setOne = new AnimatorSet();
        AnimatorSet setTwo = new AnimatorSet();


        if(!sideBarisBig && v == findViewById(R.id.TabButton)){
            return;
        }
        if(sideBarisBig && v == findViewById(R.id.UpgradeTabButton)){
            return;
        }
        ObjectAnimator SmallSideBarAnim = ObjectAnimator.ofFloat(SideBar, "translationX", (!sideBarisBig)?360f : 0f);
        SmallSideBarAnim.addListener(new Animator.AnimatorListener() {//When the small sidebar starts or finishes, it activates the second set

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!animationEnded){
                    sideBarisBig = true;
                    animationEnded = true;
                    SideBar.setVisibility(8);
                   // SmallTabButton.setVisibility(8);
                    BigSideBar.setVisibility(0);
                   // BigTabButton.setVisibility(0);
                    setTwo.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });
        ObjectAnimator BigSideBarAnim = ObjectAnimator.ofFloat(BigSideBar, "translationX", sideBarisBig?360f : 0f);
        BigSideBarAnim.addListener(new Animator.AnimatorListener() {//When the small sidebar starts or finishes, it activates the second set

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(!animationEnded){
                    sideBarisBig = false;
                    animationEnded = true;
                    SideBar.setVisibility(0);
                  //  SmallTabButton.setVisibility(0);
                    BigSideBar.setVisibility(8);
                  //  BigTabButton.setVisibility(8);
                    setOne.start();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });


        setOne.playTogether(
               // ObjectAnimator.ofFloat(SmallTabButton, "translationX", (!sideBarisBig)?360f : 0f),
                SmallSideBarAnim
        );
        setOne.setDuration(400);
        setTwo.playTogether(
               // ObjectAnimator.ofFloat(BigTabButton, "translationX", sideBarisBig?360f : 0f),
                BigSideBarAnim
        );//.723
        setTwo.setDuration(400);

        if(!sideBarisBig) {
            setOne.start();
        }
        else{
            setTwo.start();
        }

//        SmallTabButton.setVisibility(setSmall);//Gone == invisible but on steroids because it won't affect layout or be treated as existing when it's set to gone
//        SideBar.setVisibility(setSmall);
//        BigSideBar.setVisibility(setBig);
//        BigTabButton.setVisibility(setBig);
    }

    public void neutroButton(View v) {
        game.setTowerPlacementMode(TowerType.NEUTROPHIL);
    }

    public void macroButton(View v) {
        game.setTowerPlacementMode(TowerType.MACROPHAGE);
    }

    public void naiveButton(View v) {
        game.setTowerPlacementMode(TowerType.NAIVE_T_CELL);
    }

    public void resumeButton(View v) {
        game.resumeGame();
    }

    //TODO connect these methods with actual upgrade buttons in xml
    public void upgradeNeutroButton(View v) {
        game.upgrade(UpgradeType.NEUTROPHIL_TRANSFUSION);
    }

    public void upgradeMacroButton(View v) {
        game.upgrade(UpgradeType.BONE_MARROW_UPGRADE);
    }

    public void upgradeNaiveCellButton(View v) {
        game.upgrade(UpgradeType.AFFECT_NAIVE_CELL);
    }

    public void upgradeFeverButton(View v) {
        game.upgrade(UpgradeType.FEVER);
    }
    //--------------------


    public void changeText(int playerHP, int bio, int round)
    {
        runOnUiThread(new Runnable() { //can't edit UI text from the game logic thread, have to switch to the UI thread
            @Override
            public void run() {
                ((TextView)findViewById(R.id.PlayerHealth)).setText(String.format("%d", playerHP));
                ((TextView)findViewById(R.id.BiomoleculeCounter)).setText(String.format("%d", bio));
                ((TextView)findViewById(R.id.RoundCounter)).setText(String.format("Round %d", round));

            }
        });

    }

    public void devTab(View v){
        switch(v.getId()){
            case R.id.healthIncButton:
                game.incHealth();
                break;
            case R.id.bmIncButton:
                game.incBM(10);
                break;
            case R.id.nextRoundButton:
                game.nextRound();
                break;
            case R.id.decRoundButton:
                game.lastRound();
                break;
        }
    }

}