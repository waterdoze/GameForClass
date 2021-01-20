package com.example.gameforclass;

public abstract class Entity {//Maybe this class can hold the image for the entity instead of all of the lower classes
    public int tileX;
    public int tileY;
    public int screenX;
    public int screenY;
    public int entityType;

    public Entity(int tileX, int tileY, int entityType){//0 == Tower, 1 == Enemy
        this.tileX = tileX;
        this.tileY = tileY;
        this.entityType = entityType;
    }

    public int getTileX(){return tileX;}
    public int getTileY(){return tileY;}
}
