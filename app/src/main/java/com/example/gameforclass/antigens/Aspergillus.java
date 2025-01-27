package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Aspergillus extends Antigen {


    public Aspergillus(Context context, TowerDefensePog TDP) {
        super(context, TDP,80, 5, 15, Species.ASPERGILLUS, AntigenType.FUNGAL, 9, 1, 1, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }



}
