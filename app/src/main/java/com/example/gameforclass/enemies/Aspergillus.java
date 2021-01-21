package com.example.gameforclass.enemies;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.Healthbar;
import com.example.gameforclass.Map;
import com.example.gameforclass.R;

public class Aspergillus extends Enemy {

    public Aspergillus(Context context, Map map) {
        super(context, map,100, 50, EnemyType.FUNGI);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public Bitmap getImage() {
        return super.getImage();
    }

    @Override
    public Healthbar getHealthbar() {
        return super.getHealthbar();
    }
}
