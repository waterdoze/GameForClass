package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class CoronavirusSpawn extends Antigen {

    public CoronavirusSpawn(Context context, TowerDefensePog TDP) {
        super(context, TDP, 30, 3, 20, null, 30, 100, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.spawn);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

}
