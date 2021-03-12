package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class CoronaBaby extends Antigen {

    public CoronaBaby(Context context, TowerDefensePog TDP) {
        super(context, TDP, 30, 3, 20, null, AntigenType.VIRAL, 30, 100, 1, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.covid);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

}
