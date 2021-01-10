package com.example.gameforclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        configureQuitButton();
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
        startActivity(new Intent(SecondActivity.this, EasyActivity.class));
        displayToast(getString(R.string.easyChosen));
    }

    public void displayMediumMode(View view) {
        startActivity(new Intent(SecondActivity.this, EasyActivity.class));
        displayToast(getString(R.string.mediumChosen));
    }

    public void displayHardMode(View view) {
        startActivity(new Intent(SecondActivity.this, EasyActivity.class));
        displayToast(getString(R.string.hardChosen));
    }
}