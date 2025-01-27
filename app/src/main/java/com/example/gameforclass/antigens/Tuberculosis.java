package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Tuberculosis extends Antigen {


    public Tuberculosis(Context context, TowerDefensePog TDP) {

        super(context, TDP, 600, 18, 6, Species.TUBERCULOSIS, AntigenType.BACTERIAL,9, 1, 2, 32);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.tuberculosis);
        img = Bitmap.createScaledBitmap(img, TowerDefensePog.TILE_WIDTH * 2, TowerDefensePog.TILE_HEIGHT * 2, false);
        setImage(img);

    }
}