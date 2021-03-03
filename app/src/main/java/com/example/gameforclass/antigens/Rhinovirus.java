package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Rhinovirus extends Antigen {


    public Rhinovirus(Context context, TowerDefensePog TDP) {

        super(context, TDP,50, 3, 15, Species.RHINOVIRUS, 30, 100, 1, 2);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.rhinovirus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

}