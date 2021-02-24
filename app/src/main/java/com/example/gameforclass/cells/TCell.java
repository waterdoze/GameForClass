package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class TCell extends Tower{

    Bitmap killerImage;
    Bitmap helperImage;

    public TCell(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 200, 20, 100, 5, false, TowerType.NAIVE_T_CELL, 1);


        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.naivetcell);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

        killerImage = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.naivetcell);
        helperImage = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.naivetcell);
    }

    public void ascend() {
        setImage(killerImage);
    }
}