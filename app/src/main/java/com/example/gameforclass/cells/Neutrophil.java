package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Neutrophil extends Tower {
    public Neutrophil(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 150, 28, 50, 26, true, TowerType.NEUTROPHIL, 1);

        Bitmap img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.neutrophil);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

}
