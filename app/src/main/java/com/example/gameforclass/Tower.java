package com.example.gameforclass;

public class Tower extends Entity{
    public int range;
    public int damage;

    public Tower(int x, int y, int type) {
        super(x, y, type);
    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.screenX-other.screenX) ) + Math.abs( (double)(this.screenY-other.screenY) ) ) );
    }
}
/*
This needs to have the code for a tower to be held and placed, also apoptosis command?
 */