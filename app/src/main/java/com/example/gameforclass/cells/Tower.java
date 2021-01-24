package com.example.gameforclass.cells;

import android.util.Log;

import com.example.gameforclass.Entity;
import com.example.gameforclass.TowerType;
import com.example.gameforclass.antigens.Antigen;

import java.util.ArrayList;

public class Tower extends Entity {
    public int range;
    public int dmg;
    public int biomolecules;
    public int attackTimer = 0;

    public boolean isPhagocyte;//Can this cell attack stuff

    public TowerType towerType;

    public Tower(int tileX, int tileY)
    {
        super(tileX, tileY, 0);

    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.posX-other.posX) ) + Math.abs( (double)(this.posY-other.posY) ) ) );
    }

    public boolean attack(ArrayList<Antigen> enemies){ //return false if did not attack
        if(!isPhagocyte)return false;
        int dist = 99999999;
        Antigen target = null;
        double d = 0;

        if(enemies.isEmpty()) return false;

        for(Antigen a: enemies){

            d = distanceTo(a);

            if(target == null && d <= dist ){ //if there's no target yet, set it to any target
                target = a;                                                                                 //set to closest target in enemies list
            }
            else if (d <= dist && target != null && d < distanceTo(target)) target = a;

        }
        if(target == null) return false;
        target.takeDamage(dmg); //if an enemy is in range, attack
        return true;
    }
}

