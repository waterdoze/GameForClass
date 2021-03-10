package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class SpanishFlu extends Antigen {


    public SpanishFlu(Context context, TowerDefensePog TDP) {

        super(context, TDP,10, 3, 15, Species.SPANISH_FLU, AntigenType.VIRAL, 30, 100, 1, 2);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.spanishflu);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);

    }

    @Override
    public void actionOnDeath(Context context, TowerDefensePog TDP) {
        SpanishFlu duplicateOne = new SpanishFlu(context, TDP);
        SpanishFlu duplicateTwo = new SpanishFlu(context, TDP);

        duplicateOne.setCounter(this.getCounter());
        duplicateTwo.setCounter(this.getCounter());

        duplicateOne.setCurrentX(this.getX() - 60);
        duplicateTwo.setCurrentX(this.getX() + 60);
        duplicateOne.setCurrentY(this.getY());
        duplicateTwo.setCurrentY(this.getY());
        duplicateOne.setNextX(this.getNextX());
        duplicateTwo.setNextX(this.getNextX());
        duplicateOne.setNextY(this.getNextY());
        duplicateTwo.setNextY(this.getNextY());

        TDP.addEnemy(duplicateOne);
        TDP.addEnemy(duplicateTwo);
    }
}