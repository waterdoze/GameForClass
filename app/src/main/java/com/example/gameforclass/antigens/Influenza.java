package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Influenza extends Antigen {


    public Influenza(Context context, TowerDefensePog TDP) {

        super(context, TDP,50, 3, 30, Species.INFLUENZA, AntigenType.VIRAL, 30, 100, 1, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.influenza);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

}
