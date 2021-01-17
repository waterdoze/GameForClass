package com.example.gameforclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class Pneumococcus extends Enemy {//Override damage in here and add some sort of damage code that it takes in so that it resists/acts accordingly to the type of attack it is receiving


    public Pneumococcus(TowerDefensePog TDP) {

        super("Pneumococcus", 100, 5, EnemyType.BACTERIA);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, 120, 120, false);
       image = img;



    }

}
