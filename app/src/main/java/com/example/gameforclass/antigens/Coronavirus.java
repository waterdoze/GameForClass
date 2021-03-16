package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

public class Coronavirus extends Antigen {

    private int whenToAttack = 0;
    
    public Coronavirus(Context context, TowerDefensePog TDP) {

        super(context, TDP,5000, 0, 4, Species.CORONAVIRUS, AntigenType.VIRAL, 30, 100, 3, 50);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.covid);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH * 3, TDP.TILE_HEIGHT * 3, false);
        setImage(img);

    }

    public void action(Context context, TowerDefensePog TDP) {
        if (whenToAttack % 40 == 0) {
            for (int i = 0; i < 5; i++) {
                CoronaBaby spawn = new CoronaBaby(context, TDP);
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
                }

                TDP.addEnemy(spawn);

            }
        }
        whenToAttack++;
    }
}
