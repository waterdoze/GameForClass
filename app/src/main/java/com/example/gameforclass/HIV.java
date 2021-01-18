package com.example.gameforclass;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class HIV extends Enemy {

    public HIV(Bitmap unit, Map map) {
        super(unit, map, "HIV", 200, 100, EnemyType.VIRUS);
    }

}
