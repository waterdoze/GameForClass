package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Pneumococcus extends Antigen {


    public Pneumococcus(Context context, TowerDefensePog TDP) {

        super(context, TDP,50, 3, 10, AntigenType.PNEUMOCOCCUS, 30, 100);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.pneumococcus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

}
