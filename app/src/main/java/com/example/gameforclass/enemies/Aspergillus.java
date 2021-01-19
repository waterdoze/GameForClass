package com.example.gameforclass.enemies;

import android.graphics.Bitmap;

import com.example.gameforclass.Map;

public class Aspergillus extends Enemy {

    public Aspergillus(Bitmap unit, Map map) {
        super(unit, map, "Aspergillus", 100, 50, EnemyType.FUNGI);
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
}
