package com.example.gameforclass.cells;

import com.example.gameforclass.Entity;

public class Tower extends Entity {
    public int range;
    public int damage;
    public boolean isPhagocyte;

    public Tower(int tileX, int tileY) {

        super(tileX, tileY, 0);
    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.screenX-other.screenX) ) + Math.abs( (double)(this.screenY-other.screenY) ) ) );
    }
}
/*
This needs to have the code for a tower to be held and placed, also apoptosis command?
 */