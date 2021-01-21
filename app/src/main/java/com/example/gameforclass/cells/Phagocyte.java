package com.example.gameforclass.cells;

import com.example.gameforclass.TowerType;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.cells.Tower;

import java.util.ArrayList;

public class Phagocyte extends Tower {
    public TowerType towerType;
    public int damage;

    public Phagocyte(int x, int y, TowerType towerType) {
        super(x, y);
        isPhagocyte = true;
    }

    public void attack(ArrayList<Antigen> enemies){
        int dist = 99999999;
        Antigen target = null;
        for(Antigen a: enemies){
            if(distanceTo(a) <= dist){
                target = a;
            }
        }
        if(distanceTo(target) <= range){
            target.takeDamage(damage);
        }
    }
}
