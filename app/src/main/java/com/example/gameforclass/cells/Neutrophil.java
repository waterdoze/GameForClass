package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;
import com.example.gameforclass.TowerType;

public class Neutrophil extends Tower{
    public Neutrophil(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY);
        dmg = 20;
        towerType = TowerType.NEUTROPHIL;

        isPhagocyte = true;

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.neutrophilbutton);//set to neutrophil
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

}
