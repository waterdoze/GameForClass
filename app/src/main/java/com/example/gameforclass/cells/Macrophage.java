package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Macrophage extends Tower{

    private int towerAffectingRadius = 2;

    public Macrophage(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 100, 15, 80, 20, true, TowerType.MACROPHAGE);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.macrophage);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

    public int getTowerAffectingRadius() {
        return towerAffectingRadius;
    }
}