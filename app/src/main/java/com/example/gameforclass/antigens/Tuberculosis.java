package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Tuberculosis extends Antigen {


    public Tuberculosis(Context context, TowerDefensePog TDP) {

        super(context, TDP,1000, 5, 8, AntigenType.TUBERCULOSIS, 9, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.tuberculosis);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH * 2, TDP.TILE_HEIGHT * 2, false);
        setImage(img);

    }



}