package com.example.gameforclass.antigens;

import com.example.gameforclass.EnemyType;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;

public class Aspergillus extends Antigen {

    public Aspergillus(TowerDefensePog TDP)
    {
        super(30, 100, EnemyType.ASPERGILLUS, 70);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

}
