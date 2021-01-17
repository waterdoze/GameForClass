package com.example.gameforclass;

import android.widget.ImageView;

public class Pneumococcus extends Enemy {//Override damage in here and add some sort of damage code that it takes in so that it resists/acts accordingly to the type of attack it is receiving

    public Pneumococcus(ImageView view) {
        super("Pneumococcus", 100, 5, EnemyType.BACTERIA);
    }

}
