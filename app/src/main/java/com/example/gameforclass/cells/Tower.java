package com.example.gameforclass.cells;

import com.example.gameforclass.animation.AttackPellet;
import com.example.gameforclass.Entity;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.background.TowerDefensePog;

import java.util.ArrayList;

public class Tower extends Entity {

    private int range;
    private int dmg;
    private int biomolecules;
    private int attackTimer;
    private int timerCounter = 0;

    private boolean rangeToggle = false;
    private boolean isPhagocyte;//Can this cell attack stuff

    private TowerType towerType;

    private AttackPellet attackPellet;


    public Tower(int tileX, int tileY, int range, int dmg, int biomolecules, int attackTimer, boolean isPhagocyte, TowerType towerType) {

        super(tileX, tileY, 0);

        this.range = range;
        this.dmg = dmg;
        this.biomolecules = biomolecules;
        this.attackTimer = attackTimer;
        this.isPhagocyte = isPhagocyte;
        this.towerType = towerType;
    }

    public double distanceTo(Entity other) {
        return Math.sqrt( Math.pow((this.getX()-other.getX()), 2) + Math.pow(this.getY()-other.getY(), 2));
    }

    public boolean attack(ArrayList<Antigen> enemies, ArrayList<Tower> towers) { //return false if did not attack
        if (!isPhagocyte) {
            return false;
        }
        Antigen target = null;
        double d = 0;

        if(enemies.isEmpty()) return false;

        for(Antigen a: enemies) {

            d = distanceTo(a);
            if(target == null && d <= range) { //if there's no target yet, set it to any target
                target = a;                   //set to closest target in enemies list
            }

            else if (d <= range && target != null && d < distanceTo(target)) target = a;
        }
        if(target == null) {
            return false;
        }
        target.takeDamage(dmg); //if an enemy is in range, attack
        //attackPellet = new AttackPellet(tileX*TowerDefensePog.TILE_WIDTH + TowerDefensePog.TILE_WIDTH/2, tileY*TowerDefensePog.TILE_HEIGHT + TowerDefensePog.TILE_HEIGHT/2, target.posX, target.posY, dmg);
        attackPellet = new AttackPellet(posX, posY, target.posX, target.posY, dmg);
        return true;
    }

    public void switchRangeToggle() {
        rangeToggle = !rangeToggle;
    }

    public boolean rangeToggleIsOn() {
        return rangeToggle;
    }


    public AttackPellet getAttackPellet() {
        return attackPellet;
    }

    public TowerType getTowerType() {
        return towerType;
    }

    public int getDmg() {
        return dmg;
    }

    public int getRange() { return range; }

    public int getAttackTimer() {
        return attackTimer;
    }

    public int getBiomolecules() {
        return biomolecules;
    }

    public int getTimerCounter() {
        return timerCounter;
    }

    public void setTimerCounter(int time) {
        timerCounter = time;
    }

    public void setAttackPellet(AttackPellet a) {
        attackPellet = a;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setRange(int range) {
        this.range = range;
    }



}

