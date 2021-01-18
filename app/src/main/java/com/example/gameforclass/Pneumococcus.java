package com.example.gameforclass;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Pneumococcus extends Enemy {

    public Pneumococcus(Bitmap unit, Map map) {
        super(unit, map, "Pneumococcus", 100, 5, EnemyType.BACTERIA);
    }

}
