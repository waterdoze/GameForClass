package com.example.gameforclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class EasyActivity extends AppCompatActivity {

    private int screenWidth;
    private int screenHeight;
    private int gear = 0;


    private ImageView aspergillus;

    private float aspergillusX;
    private float aspergillusY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        aspergillus = findViewById(R.id.aspergillus);

        WindowManager window = getWindowManager();
        Display display = window.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        float initialX = (float) (screenWidth * .36);
        float initialY = (float) (screenHeight * 0);

        aspergillus.setX(initialX);
        aspergillusX = initialX;
        aspergillus.setY(initialY);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        }, 0, 20);
        Log.d("tagnumero1", "Hello World!");
    }

    public void changePos() {
        switch (gear) {
            case 0:
                if (aspergillus.getY() + aspergillus.getHeight() < screenHeight * .29) {
                    aspergillusY += screenHeight * .005;
                    aspergillus.setY(aspergillusY);
                }
                else {
                    gear = 1;
                }
                break;
            case 1:
                if (aspergillus.getX() > screenWidth * 0.325) {
                    aspergillusX -= screenWidth * .003;
                    aspergillus.setX(aspergillusX);
                    aspergillusY += screenHeight * .001;
                    aspergillus.setY(aspergillusY);
                }
                else {
                    gear = 2;
                }
                break;
            case 2:
                if (aspergillus.getX() > screenWidth * .27) {
                    aspergillusX -= screenWidth * .0014;
                    aspergillus.setX(aspergillusX);
                    aspergillusY -= screenHeight * .006;
                    aspergillus.setY(aspergillusY);
                }
                else {
                    gear = 3;
                }
                break;
            case 3:
                if (aspergillus.getX() > screenWidth * .1) {
                    aspergillusX -= screenWidth * .0025;
                    aspergillus.setX(aspergillusX);
                    aspergillusY += screenHeight * .004;
                    aspergillus.setY(aspergillusY);
                }
                else {
                    gear = 4;
                }
                break;
            case 4:
                if (aspergillus.getX() > screenWidth * .065) {
                    aspergillusX -= screenWidth * .00046;
                    aspergillus.setX(aspergillusX);
                    aspergillusY += screenHeight * .005;
                    aspergillus.setY(aspergillusY);
                }
                else {
                    gear = 4;
                }
                break;
        }



    }



}