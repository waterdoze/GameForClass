package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Entity;
import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;

public class Pneumococcus extends Antigen {


    public Pneumococcus(Context context, TowerDefensePog TDP) {

        super(context, TDP,70, 50, 20, EnemyType.PNEUMOCOCCUS, 30, 100);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

}
