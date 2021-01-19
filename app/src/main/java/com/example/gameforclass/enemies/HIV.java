package com.example.gameforclass.enemies;

import android.graphics.Bitmap;

import com.example.gameforclass.Map;

public class HIV extends Enemy {

    public HIV(Bitmap unit, Map map) {
        super(unit, map, "HIV", 200, 100, EnemyType.VIRUS);
    }

}
