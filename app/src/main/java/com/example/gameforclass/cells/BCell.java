package com.example.gameforclass.cells;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class BCell extends Tower{


    public BCell(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 125, 10, 50, 10, true, TowerType.B_CELL, 1);

        Bitmap img;
        if (TDP.bCellisUpgraded()) {
            img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.bcelluprgraded);
            img = Bitmap.createScaledBitmap(img, (int) (TDP.TILE_WIDTH * 1.4), (int) (TDP.TILE_HEIGHT * 1.4), false);

            setSizeMultiplier(1.4);
            setDmg(getDmg() + 20);
            setRange(getRange() + 100);
        }
        else {
            img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.bcell);
            img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);

        }
        setImage(img);
    }

}
