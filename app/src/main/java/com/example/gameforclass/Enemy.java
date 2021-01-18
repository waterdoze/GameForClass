package com.example.gameforclass;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

class Enemy {

    public int IMG_HEIGHT = TowerDefensePog.TILE_HEIGHT; //Size of sprite will be same size as tile for now i guess
    public int IMG_WIDTH = TowerDefensePog.TILE_WIDTH;


    public enum EnemyType {
        VIRUS, FUNGI, BACTERIA
    }

    private String name;
    public Bitmap image;
    private int health, biomolecule;
    private EnemyType type;

    public int x, y; //position
    public int dx, dy; //velocity



    public Enemy(String name, int health, int biomolecule, EnemyType type) {
        this.name = name;
        this.health = health;
        this.biomolecule = biomolecule;
        this.type = type;
        x=y=dx=dy=0;

    }

    public void destroy() {

    }

     public EnemyType getType() {
        return type;
     }

     public int getBiomolecule() {
        return biomolecule;
     }

     public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            destroy();
        }
     }





}
