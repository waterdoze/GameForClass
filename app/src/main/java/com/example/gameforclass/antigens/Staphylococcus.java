package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Staphylococcus extends Antigen {


    public Staphylococcus(Context context, TowerDefensePog TDP) {

        super(context, TDP,1200, 25, 6, Species.STAPHYLOCOCCUS, AntigenType.BACTERIAL, 9, 1, 2, 30);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.staphylococcus);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH * 2, TDP.TILE_HEIGHT * 2, false);
        setImage(img);

    }

    @Override
    public void actionOnDeath(Context context, TowerDefensePog TDP) {

        for (int i = 0; i < 8; i++) {
            StaphylococcusSpawn spawn = new StaphylococcusSpawn(context, TDP);
            spawn.setCounter(this.getCounter());

            switch (i) {
                case 0:
                    spawn.setCurrentX(this.getX() - 30);
                    spawn.setCurrentY(this.getY() - 30);
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 1:
                    spawn.setCurrentX(this.getX());
                    spawn.setCurrentY(this.getY() - 30);
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 2:
                    spawn.setCurrentX(this.getX() + 30);
                    spawn.setCurrentY(this.getY() - 30);
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 3:
                    spawn.setCurrentX(this.getX() - 30);
                    spawn.setCurrentY(this.getY());
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 4:
                    spawn.setCurrentX(this.getX());
                    spawn.setCurrentY(this.getY());
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 5:
                    spawn.setCurrentX(this.getX() + 30);
                    spawn.setCurrentY(this.getY());
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 6:
                    spawn.setCurrentX(this.getX() - 15);
                    spawn.setCurrentY(this.getY() + 30);
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
                case 7:
                    spawn.setCurrentX(this.getX() + 15);
                    spawn.setCurrentY(this.getY() + 30);
                    spawn.setNextX(this.getNextX());
                    spawn.setNextY(this.getNextY());
                    break;
            }

            TDP.addEnemy(spawn);

        }


    }
}