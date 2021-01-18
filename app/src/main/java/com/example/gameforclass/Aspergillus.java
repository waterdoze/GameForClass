package com.example.gameforclass;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Aspergillus extends Enemy {

    public Aspergillus(Bitmap unit, Map map) {
        super(unit, map, "Aspergillus", 100, 50, EnemyType.FUNGI);
    }

    @Override
    public void move() {
        super.move();
    }


}
