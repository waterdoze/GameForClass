package com.example.gameforclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class HIV extends Enemy {

    public HIV(TowerDefensePog TDP) {

        super("HIV", 200, 100, EnemyType.VIRUS);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);



        img = Bitmap.createScaledBitmap(img, IMG_WIDTH, IMG_HEIGHT, false);
        image = img;
    }

}
