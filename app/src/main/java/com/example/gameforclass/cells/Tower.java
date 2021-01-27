package com.example.gameforclass.cells;

import com.example.gameforclass.animation.AttackPellet;
import com.example.gameforclass.Entity;
import com.example.gameforclass.antigens.Antigen;

import java.util.ArrayList;

public class Tower extends Entity {
    public int range;
    public int dmg;
    public int biomolecules;
    public int attackTimer = 50;
    public AttackPellet attackPellet;

    public boolean isPhagocyte;//Can this cell attack stuff

    public TowerType towerType;

    public Tower(int tileX, int tileY)
    {
        super(tileX, tileY, 0);
    }

    public double distanceTo(Entity other){
        return Math.sqrt( ( Math.abs( (double)(this.posX-other.posX) ) + Math.abs( (double)(this.posY-other.posY) ) ) );
    }

    public boolean attack(ArrayList<Antigen> enemies){ //return false if did not attack
        if(!isPhagocyte)return false;
        Antigen target = null;
        double d = 0;

        if(enemies.isEmpty()) return false;

        for(Antigen a: enemies){

            d = distanceTo(a);

            if(target == null && d <= range ){ //if there's no target yet, set it to any target
                target = a;                   //set to closest target in enemies list
            }
            else if (d <= range && target != null && d < distanceTo(target)) target = a;

        }
        if(target == null) return false;
        target.takeDamage(dmg); //if an enemy is in range, attack
        //attackPellet = new AttackPellet(tileX*TowerDefensePog.TILE_WIDTH + TowerDefensePog.TILE_WIDTH/2, tileY*TowerDefensePog.TILE_HEIGHT + TowerDefensePog.TILE_HEIGHT/2, target.posX, target.posY, dmg);
        attackPellet = new AttackPellet(posX, posY, target.posX, target.posY, dmg);
        return true;
    }

    public AttackPellet getAttackPellet() {
        return attackPellet;
    }

    public void setAttackPellet(AttackPellet a) {
        attackPellet = a;
    }

    public int getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(int attackTimer) {
        this.attackTimer = attackTimer;
    }

    public int getBiomolecules() {
        return biomolecules;
    }

}

