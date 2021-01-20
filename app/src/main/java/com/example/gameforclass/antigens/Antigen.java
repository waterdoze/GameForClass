package com.example.gameforclass.antigens;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Entity;

public class Antigen extends Entity {
    public int dx;
    public int dy;
    public int health;
    public EnemyType antigenType;


    public Antigen(int tileX, int tileY, EnemyType antigenType, int health) {
        super(tileX, tileY, 1);
        this.antigenType = antigenType;
        this.health = health;
        switch(antigenType){//make image here?
        }
    }

    public void move(){
        screenX+=dx;
        screenY+=dy;
    }


}
