package com.example.gameforclass.cells;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.gameforclass.R;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.antigens.AntigenType;
import com.example.gameforclass.antigens.Species;
import com.example.gameforclass.background.TowerDefensePog;

import java.util.ArrayList;

public class BCell extends Tower{

    ArrayList<Antigen> target = new ArrayList<Antigen>();
    boolean thereIsATarget = false;



    public BCell(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 175, 5, 100, 15, true, TowerType.B_CELL, 1);

        Bitmap img;
        if (TDP.bCellisUpgraded()) {
            img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.bcelluprgraded);
            img = Bitmap.createScaledBitmap(img, (int) (TDP.TILE_WIDTH * 1.4), (int) (TDP.TILE_HEIGHT * 1.4), false);

            setSizeMultiplier(1.4);
            setDmg(getDmg() + 20);
            setRange(getRange() + 100);
        } else {
            img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.bcell);
            img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);

        }
        setImage(img);

    }


    @Override
    public boolean attack(ArrayList<Antigen> enemies, ArrayList<Tower> towers) {
        double d = 0;

        if(enemies.isEmpty() || boost == null) {
            return false;
        }
        else {
            for (Antigen a : enemies) {

                d = distanceTo(a);
                if (d <= getRange() && ( a.getType() != AntigenType.VIRAL || boost == AntigenType.VIRAL)) { //if there's any target in range, set it
                    target.add(a);
                }
            }
            if (target == null) {
                return false;
            }
            for (Antigen a : target) {//if an enemy is in range, attack
                if (distanceTo(a) <= getRange()) {
                    a.takeDamage(getDmg());
                }
            }
            for (Antigen a: target) {
                if (a.getHealth() <= 0 || distanceTo(a) > getRange()) {
                    thereIsATarget = false;
                } else {
                    thereIsATarget = true;
                    break;
                }
            }

            if (!hasTarget()) {
                setTimerCounter(0);
            }
            //attackPellet = new AttackPellet(tileX*TowerDefensePog.TILE_WIDTH + TowerDefensePog.TILE_WIDTH/2, tileY*TowerDefensePog.TILE_HEIGHT + TowerDefensePog.TILE_HEIGHT/2, target.posX, target.posY, dmg);
            return true;
        }
    }

    @Override
    public boolean hasTarget() {
        return thereIsATarget;
    }
}
