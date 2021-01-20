package com.example.gameforclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class Aspergillus extends Enemy {

    public Aspergillus(TowerDefensePog TDP)
    {
        super("Aspergillus", 100, 50, EnemyType.FUNGI);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, IMG_WIDTH, IMG_HEIGHT, false);
        image = img;
    }

}
