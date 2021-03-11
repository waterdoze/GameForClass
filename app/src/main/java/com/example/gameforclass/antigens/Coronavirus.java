package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Coronavirus extends Antigen {


    public Coronavirus(Context context, TowerDefensePog TDP) {

        super(context, TDP,50, 3, 30, Species.CORONAVIRUS, AntigenType.VIRAL, 30, 100, 1, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.covid);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH * 3, TDP.TILE_HEIGHT * 3, false);
        setImage(img);

    }

    public void action() {
        
    }

}
