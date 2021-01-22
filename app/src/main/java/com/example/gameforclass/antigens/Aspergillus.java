package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Healthbar;
import com.example.gameforclass.Map;
import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;
import com.example.gameforclass.antigens.Antigen;

public class Aspergillus extends Antigen {

    public Aspergillus(Context context, Map map) {
        super(context, map,100, 50, EnemyType.ASPERGILLUS, 30, 100);
    }

    public Aspergillus(TowerDefensePog TDP)
    {
        super(30, 100, EnemyType.ASPERGILLUS, 70);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.aspergillus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public Bitmap getImage() {
        return super.getImage();
    }

    @Override
    public Healthbar getHealthbar() {
        return super.getHealthbar();
    }
}
