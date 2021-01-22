package com.example.gameforclass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import com.example.gameforclass.antigens.Antigen;

public class Healthbar {

    private Antigen antigen;
    private int width, height, margin;
    private Paint healthPaint;

    public Healthbar(Context context, Antigen antigen) {
        this.antigen = antigen;

        width = 100;
        height = 20;

        int borderColor = ContextCompat.getColor(context, R.color.health_bar_border);
        healthPaint = new Paint();
        healthPaint.setColor(borderColor);
    }

    public void draw(Canvas canvas) {

        float x = (float) antigen.getX();
        float y = (float) antigen.getY();
        float distanceToPlayer = 30;
        float healthPointPercentage = (float) antigen.getHealth() / antigen.getMaxHealth();
        float healthLeft, healthTop, healthRight, healthBottom, healthWidth, healthHeight;

        healthWidth = width;
        healthLeft = x - width / 2;
        healthRight = healthLeft + healthWidth * healthPointPercentage;
        healthBottom = y - distanceToPlayer;
        healthTop = healthBottom - height;

        canvas.drawRect(healthLeft, healthTop, healthRight, healthBottom, healthPaint);
    }


}
