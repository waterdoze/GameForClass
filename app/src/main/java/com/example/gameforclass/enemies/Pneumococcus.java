package com.example.gameforclass.enemies;

import android.graphics.Bitmap;

import com.example.gameforclass.Map;

public class Pneumococcus extends Enemy {

    public Pneumococcus(Bitmap unit, Map map) {
        super(unit, map, "Pneumococcus", 100, 5, EnemyType.BACTERIA);
    }

}
