package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Anthrax extends Antigen {


    public Anthrax(Context context, TowerDefensePog TDP) {

        super(context, TDP,150, 3, 20, Species.ANTHRAX, AntigenType.BACTERIAL,30, 100, 1, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.anthrax);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

}