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
    }

    public void move(){
        screenX+=dx;
        screenY+=dy;
    }

    public void takeDamage(int dmg){
        if(health > dmg){
            health-=dmg;
        }
        else{
            health = 0;//Set some kind of death animation/other costume?
        }
    }

}
