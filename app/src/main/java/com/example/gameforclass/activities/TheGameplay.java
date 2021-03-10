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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gameforclass.R;
import com.example.gameforclass.animation.EmotionalSupport;
import com.example.gameforclass.antigens.AntigenType;
import com.example.gameforclass.antigens.Species;
import com.example.gameforclass.background.TowerDefensePog;
import com.example.gameforclass.cells.TowerType;
import com.example.gameforclass.cells.UpgradeType;

import java.util.ArrayList;

public class TheGameplay extends AppCompatActivity {

    private int difficulty = 0; //EASY = 1; MEDIUM = 2; HARD = 3;

    private float shiftVal = 400f;

    private boolean ableToSell = false;

    //TheGameplay is the activity in which the GameFragment class runs in

    TowerDefensePog game;

    private int currentBarID; private int currentButtonID;
    private EmotionalSupport eButton;
    private ImageButton sellButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Intent i = getIntent();
        difficulty = i.getIntExtra("difficulty", 0); //If data not received, 0 is returned

        setContentView(R.layout.activity_the_gameplay); //Use the layout file to organize the screen

        eButton = new EmotionalSupport(getApplicationContext());
        sellButton = findViewById(R.id.apoptosisButton);

        game = (TowerDefensePog) findViewById(R.id.gameFragment);

        currentBarID = R.id.SideBar; currentButtonID = R.id.TabButton;

        AnimatorSet invisAnim = new AnimatorSet();
        invisAnim.setDuration(50);
        invisAnim.playTogether(
                ObjectAnimator.ofFloat(findViewById(R.id.UpgradeSideBar), "translationX", shiftVal),
                ObjectAnimator.ofFloat(findViewById(R.id.InventoryBar), "translationX", shiftVal)
        );
        invisAnim.start();
    }


    //SETVISIBILITY VALUES: 0 == VISIBLE      4 == INVISIBLE      8 == GONE
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("WrongConstant")//Allows the setVisibility to take values other than the constants
    public void changeSideBar(View v){//If the expand button is pressed, this is called. Animation will be added soon
        ScrollView currentBar = findViewById(currentBarID);
        ScrollView targetBar = findViewById(v.getId() == R.id.TabButton?R.id.SideBar:(v.getId() == R.id.UpgradeTabButton?R.id.UpgradeSideBar:R.id.InventoryBar));
        ImageView barBackground = findViewById(R.id.SidebarBackground);
//        ImageButton currentButton = (ImageButton)v;
//        ImageButton targetButton =
//
//        ImageButton SmallTabButton = findViewById(R.id.TabButton);
//        ImageButton BigTabButton = findViewById(R.id.UpgradeTabButton);

        AnimatorSet setOne = new AnimatorSet();
        AnimatorSet setTwo = new AnimatorSet();

        if(currentBar == targetBar){
            return;
        }
        ObjectAnimator currentBarAnim = ObjectAnimator.ofFloat(currentBar, "translationX", shiftVal);
        currentBarAnim.addListener(new Animator.AnimatorListener() {//When the small sidebar starts or finishes, it activates the second set

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                currentBar.setVisibility(8);
                // SmallTabButton.setVisibility(8);
                targetBar.setVisibility(0);
                // BigTabButton.setVisibility(0);
                setTwo.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });
        ObjectAnimator targetBarAnim = ObjectAnimator.ofFloat(targetBar, "translationX", 0f);
        targetBarAnim.addListener(new Animator.AnimatorListener() {//When the small sidebar starts or finishes, it activates the second set

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });


        setOne.playTogether(
                ObjectAnimator.ofFloat(barBackground, "translationX", 410f),
                currentBarAnim
        );
        setOne.setDuration(400);
        setTwo.playTogether(
                ObjectAnimator.ofFloat(barBackground, "translationX", 0f),
                targetBarAnim
        );//.723
        setTwo.setDuration(400);
        setOne.start();

        currentBarID = targetBar.getId();
//        SmallTabButton.setVisibility(setSmall);//Gone == invisible but on steroids because it won't affect layout or be treated as existing when it's set to gone
//        SideBar.setVisibility(setSmall);
//        BigSideBar.setVisibility(setBig);
//        BigTabButton.setVisibility(setBig);
    }

    public void createEndScreen() {

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

    public void bCellButton(View v) { game.setTowerPlacementMode(TowerType.B_CELL); }

    public void dendriticButton(View v) {
        game.setTowerPlacementMode(TowerType.DENDRITIC_CELL);
    }

    public void resumeButton(View v) {
        game.resumeGame();
    }

    public void emotionalSupportButton(View v) {
        eButton.displayMessage();
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

    public void upgradeBCellButton(View v) { game.upgrade(UpgradeType.AFFECT_B_CELL);}

    public void upgradeAntibioticButton(View v) {
        game.upgrade(UpgradeType.ANTIBIOTIC);
    }

    public void AntigenButton(View v)
    {
        switch(v.getId())
        {
            case R.id.FungalGuyButton:
                game.addAntigen(AntigenType.FUNGAL);
                break;
            case R.id.BacterialGuyButton:
                game.addAntigen(AntigenType.BACTERIAL);
                break;
            case R.id.ViralGuyButton:
                game.addAntigen(AntigenType.VIRAL);
                break;
        }
    }

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


    public void updateInventory(ArrayList<AntigenType> inventory)
    {
        runOnUiThread(new Runnable() { //can't edit UI text from the game logic thread, have to switch to the UI thread
            @Override
            public void run() {
                TextView fungal = findViewById(R.id.FungalCount);
                TextView bacterial = findViewById(R.id.BacterialCount);
                TextView viral = findViewById(R.id.ViralCount);

                int f,b,v;
                f=b=v=0;

                for(int i=0; i < inventory.size(); i++)
                {
                    switch(inventory.get(i))
                    {
                        case VIRAL: v++; break;
                        case BACTERIAL: b++; break;
                        case FUNGAL: f++; break;
                    }
                }

                fungal.setText(Integer.toString(f));
                bacterial.setText(Integer.toString(b));
                viral.setText(Integer.toString(v));
            }
        });

    }

    public void devTab(View v){
        switch(v.getId()){
            case R.id.apoptosisButton:
                if (ableToSell) {
                    game.toggleSellMode();
                }
                break;
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

    public void switchSellButtonToggle() {
        ableToSell = !ableToSell;
        if (ableToSell) {
            sellButton.setImageResource(R.drawable.apoptosisbuttonenabled);
        } else {
            sellButton.setImageResource(R.drawable.apoptosisbuttondisabled);
        }
    }
}
