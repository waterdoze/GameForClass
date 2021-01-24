package com.example.gameforclass;

import android.graphics.Bitmap;

public abstract class Entity {//Maybe this class can hold the image for the entity instead of all of the lower classes
    public int tileX;
    public int tileY;
    public int posX;
    public int posY;
    public int entityType;
    public Bitmap image;

    public Entity(int tileX, int tileY, int entityType){//0 == Tower, 1 == Enemy
        this.tileX = tileX;
        this.tileY = tileY;
        posX = tileX * TowerDefensePog.TILE_WIDTH;
        posY = tileY * TowerDefensePog.TILE_HEIGHT;
        this.entityType = entityType;
    }

    public void setImage(Bitmap costume){
        image = costume;
    }

    public int getTileX(){return tileX;}
    public int getTileY(){return tileY;}
}
