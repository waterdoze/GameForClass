package com.example.gameforclass;

public class Entity {
    public int x;
    public int y;
    public int type;

    public Entity(int x, int y, int type){//0 == Tower, 1 == Enemy
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.x-other.x) ) + Math.abs( (double)(this.y-other.y) ) ) );
    }
}
