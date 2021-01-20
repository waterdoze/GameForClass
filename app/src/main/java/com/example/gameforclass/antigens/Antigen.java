package com.example.gameforclass.antigens;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Entity;

public class Antigen extends Entity {
    public int dx;
    public int dy;
    public EnemyType antigenType;


    public Antigen(int tileX, int tileY,EnemyType antigenType) {
        super(tileX, tileY, 1);
        this.antigenType = antigenType;
        switch(antigenType){//make image here?
        }
    }

    public void move(){
        screenX+=dx;
        screenY+=dy;
    }


}
