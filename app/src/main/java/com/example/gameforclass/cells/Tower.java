package com.example.gameforclass.cells;

import com.example.gameforclass.Entity;
import com.example.gameforclass.TowerType;
import com.example.gameforclass.antigens.Antigen;

import java.util.ArrayList;

public class Tower extends Entity {
    public int range;
    public int dmg;
    public boolean isPhagocyte;
    public TowerType towerType;

    public Tower(int tileX, int tileY) {
        super(tileX, tileY, 0);

    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.screenX-other.screenX) ) + Math.abs( (double)(this.screenY-other.screenY) ) ) );
    }

    public void attack(ArrayList<Antigen> enemies){
        if(!isPhagocyte)return;
        int dist = 99999999;
        Antigen target = null;
        for(Antigen a: enemies){
            if(distanceTo(a) <= dist){
                target = a;
            }
        }
        if(distanceTo(target) <= range){
            target.takeDamage(dmg);
        }
    }
}
/*
This needs to have the code for a tower to be held and placed, also apoptosis command?
 */