package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;
import com.example.gameforclass.TowerType;

public class Neutrophil extends Phagocyte{
    public Neutrophil(int x, int y, TowerDefensePog TDP) {
        super(x, y, TowerType.NEUTROPHIL);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);//set to neutrophil
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }
}
