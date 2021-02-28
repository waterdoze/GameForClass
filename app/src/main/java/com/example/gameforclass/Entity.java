package com.example.gameforclass;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.gameforclass.background.TowerDefensePog;

public abstract class Entity {//Maybe this class can hold the image for the entity instead of all of the lower classes
    public int tileX;
    public int tileY;

    public int posX;
    public int posY;

    public double sizeMultiplier;
    public int imageX;
    public int imageY;
    
    public int entityType;
    public Bitmap image;

    public Entity(int tileX, int tileY, int entityType, double sizeMultiplier){//0 == Tower, 1 == Enemy

        this.sizeMultiplier = sizeMultiplier;
        this.tileX = tileX;
        this.tileY = tileY;

        posX = tileX * TowerDefensePog.TILE_WIDTH;
        posY = tileY * TowerDefensePog.TILE_HEIGHT;

        imageX = posX - (int) Math.abs((1.0 * TowerDefensePog.TILE_WIDTH - 1.0 * TowerDefensePog.TILE_WIDTH * sizeMultiplier) / 2);
        imageY = posY - (int) Math.abs((1.0 * TowerDefensePog.TILE_HEIGHT - 1.0 * TowerDefensePog.TILE_HEIGHT * sizeMultiplier) / 2);


        this.entityType = entityType;
    }

    public void setImage(Bitmap costume){
        image = costume;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getTileX() {return tileX;}

    public int getTileY() {return tileY;}

    public int getImageX() {
        return imageX;
    }

    public int getImageY() {
        return imageY;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void setX(int x) {
        posX = x;
        setImageX();
    }

    public void setY(int y) {
        posY = y;
        setImageY();
    }

    public void setImageX() {
        imageX = posX - (int) Math.abs((1.0 * TowerDefensePog.TILE_WIDTH - 1.0 * TowerDefensePog.TILE_WIDTH * sizeMultiplier) / 2);
    }

    public void setImageY() {
        imageY = posY - (int) Math.abs((1.0 * TowerDefensePog.TILE_HEIGHT - 1.0 * TowerDefensePog.TILE_HEIGHT * sizeMultiplier) / 2);
    }

    public void setSizeMultiplier(double multiplier) {
        sizeMultiplier = multiplier;
        imageX = posX - (int) Math.abs((1.0 * TowerDefensePog.TILE_WIDTH - 1.0 * TowerDefensePog.TILE_WIDTH * sizeMultiplier) / 2);
        imageY = posY - (int) Math.abs((1.0 * TowerDefensePog.TILE_HEIGHT - 1.0 * TowerDefensePog.TILE_HEIGHT * sizeMultiplier) / 2);
    }
}
