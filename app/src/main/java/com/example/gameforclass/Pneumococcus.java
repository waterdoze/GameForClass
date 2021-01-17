package com.example.gameforclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class Pneumococcus extends Enemy {


    public Pneumococcus(TowerDefensePog TDP) {

        super("Pneumococcus", 100, 5, EnemyType.BACTERIA);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, 120, 120, false);
       image = img;



    }

}
