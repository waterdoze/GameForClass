package com.example.gameforclass.cells;

import com.example.gameforclass.Entity;
import com.example.gameforclass.TowerType;
import com.example.gameforclass.antigens.Antigen;

import java.util.ArrayList;

public class Tower extends Entity {
    public int range;
    public int dmg;
    public int biomolecules;

    public boolean isPhagocyte;//Can this cell attack stuff

    public TowerType towerType;

    public Tower(int tileX, int tileY) {
        super(tileX, tileY, 0);
    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.posX-other.posX) ) + Math.abs( (double)(this.posY-other.posY) ) ) );
    }

    public void attack(ArrayList<Antigen> enemies){
        if(!isPhagocyte)return;
        int dist = 99999999;
        Antigen target = null;

        if(enemies.isEmpty()) return;

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
j
 */