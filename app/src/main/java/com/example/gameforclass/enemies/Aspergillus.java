package com.example.gameforclass.enemies;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.gameforclass.Healthbar;
import com.example.gameforclass.Map;

public class Aspergillus extends Antigen {

    public Aspergillus(Context context, Map map) {
        super(context, map,100, 50, EnemyType.FUNGI, 30, 100);
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
