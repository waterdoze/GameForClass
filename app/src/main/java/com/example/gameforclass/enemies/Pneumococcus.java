package com.example.gameforclass.enemies;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.gameforclass.Map;

public class Pneumococcus extends Enemy {

    public Pneumococcus(Context context, Map map) {
        super(context, map, 100, 5, EnemyType.BACTERIA);
    }

}
