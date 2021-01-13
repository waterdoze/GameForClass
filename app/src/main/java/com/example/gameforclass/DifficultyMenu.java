package com.example.gameforclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DifficultyMenu extends AppCompatActivity {

    Intent mailman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        configureQuitButton();

        mailman = new Intent(this, TheGameplay.class);
    }

    private void configureQuitButton() {
        Button nextButton = (Button) findViewById(R.id.quitButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void displayEasyMode(View view) {
        mailman.putExtra("difficulty", 1);
        startActivity(mailman);
        displayToast(getString(R.string.easyChosen));

    }

    public void displayMediumMode(View view) {
        mailman.putExtra("difficulty", 2);
        startActivity(mailman);
        displayToast(getString(R.string.mediumChosen));
    }

    public void displayHardMode(View view) {
        mailman.putExtra("difficulty", 3);
        startActivity(mailman);
        displayToast(getString(R.string.hardChosen));
    }
}