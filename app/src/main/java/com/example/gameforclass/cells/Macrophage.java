package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.R;
import com.example.gameforclass.animation.AttackPellet;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.background.TowerDefensePog;

import java.util.ArrayList;

public class Macrophage extends Tower{

    public Macrophage(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 200, 15, 80, 20, true, TowerType.MACROPHAGE, 1);

        Bitmap img =  BitmapFactory.decodeResource(TDP.getResources(), R.drawable.macrophage);
        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }


    @Override
    public boolean attack(ArrayList<Antigen> enemies, ArrayList<Tower> towers) {
        if (!isPhagocyte()) {
            return false;
        }
        else {
            Antigen target = null;
            double d = 0;

            if (enemies.isEmpty()) return false;

            for (Antigen a : enemies) {

                d = distanceTo(a);
                if (target == null && d <= getRange()) { //if there's no target yet, set it to any target
                    target = a;                   //set to closest target in enemies list
                }
                else if (d <= getRange() && target != null && d < distanceTo(target)) {
                    target = a;
                }
            }
            if (target == null) {
                return false;
            } else {
                target.takeDamage(getDmg()); //if an enemy is in range, attack
                //attackPellet = new AttackPellet(tileX*TowerDefensePog.TILE_WIDTH + TowerDefensePog.TILE_WIDTH/2, tileY*TowerDefensePog.TILE_HEIGHT + TowerDefensePog.TILE_HEIGHT/2, target.posX, target.posY, dmg);
                setAttackPellet(new AttackPellet(posX, posY, target.posX, target.posY, getDmg()));
                return true;
            }
        }
    }
}