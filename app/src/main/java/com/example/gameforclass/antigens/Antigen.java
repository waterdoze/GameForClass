package com.example.gameforclass.antigens;

import android.content.Context;
import android.util.Log;

import com.example.gameforclass.Entity;
import com.example.gameforclass.animation.Healthbar;
import com.example.gameforclass.background.Map;
import com.example.gameforclass.R;
import com.example.gameforclass.background.TowerDefensePog;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Antigen extends Entity {



    private int health, maxHealth, biomolecule;
    public int velocity;
    private double currentX, currentY, nextX, nextY;
    private int gear = 0, counter = 2;
    public int dy, dx;

    private boolean pathFinished = false;

    private int screenX, screenY; //SIZE OF THE FRAGMENT

    private AntigenType type;
    private Map map;
    private ArrayList<Double> path;
    private Healthbar healthbar;

    public Antigen(Context context, TowerDefensePog TDP, int health, int biomolecule, int velocity, AntigenType type, int tileX, int tileY) {

        super(tileX, tileY, 1);

        screenX = 1440; screenY = 900; //SIZE OF THE FRAGMENT
        map = new Map(TDP.getResources().getString(R.string.map_coordinate), screenX, screenY);


        this.health = health;
        this.biomolecule = biomolecule;
        this.type = type;
        dy = dx = 0;

        maxHealth = health;
        this.velocity = velocity;

        path = map.getSolvedCoordinateArray();

        healthbar = new Healthbar(context, this);

        currentX = path.get(counter - 2);
        currentY = path.get(counter - 1);
        nextX = path.get(counter);
        nextY = path.get(counter + 1);
        counter += 2;


    }

    public void actionOnDeath(Context context, TowerDefensePog TDP) {
        return;
    }

    public void takeDamage(int damage) {

        health -= damage;
        if(health < 0) health = 0;
    }

    public void move() {

        if(pathFinished) return;

        double changeX;
        double changeY;

        if (!(currentX == nextX && currentY == nextY)){
            if (currentX == nextX && currentY != nextY) {

                if (nextY < currentY) {
                    changeY = -1 * velocity;
                    currentY += changeY;
                    if (currentY < nextY) {
                        currentY = nextY;
                    }

                }
                else {
                    changeY = velocity;
                    currentY += changeY;
                    if (currentY > nextY) {
                        currentY = nextY;
                    }
                }
            } else if (currentY == nextY && currentX != nextX) {

                if (nextX < currentX) {
                    changeX = -1 * velocity;
                    currentX += changeX;
                    if (currentX < nextX) {
                        currentX = nextX;
                    }
                }
                else {
                    changeX = velocity;
                    currentX += changeX;
                    if (currentX > nextX) {
                        currentX = nextX;
                    }
                }
            } else if (!(currentX == nextX) && !(currentY == nextY)) {

                double slope = map.createSlope(nextX - currentX, nextY - currentY);
                changeX = Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1));
                changeY = Math.abs(slope * Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1)));

                if (currentX > nextX) {
                    currentX -= changeX;
                    if (currentX < nextX) {
                        currentX = nextX;
                    }
                }
                if (currentX < nextX) {
                    currentX += changeX;
                    if (currentX > nextX) {
                        currentX = nextX;
                    }
                }
                if (currentY > nextY) {
                    currentY -= changeY;
                    if (currentY < nextY) {
                        currentY = nextY;
                    }
                }
                if (currentY < nextY) {
                    currentY += changeY;
                    if (currentY > nextY) {
                        currentY = nextY;
                    }
                }

            }
        }
        else {
            if (counter < path.size()) {
                nextX = path.get(counter);
                nextY = path.get(counter + 1);
                counter += 2;
            }
            else
            {
                pathFinished = true;
                return;
            }
        }

        posX = (int)currentX;
        posY = (int)currentY;
    }

    public AntigenType getType() {
        return type;
    }

    public int getX() {
        return (int) currentX;
    }

    public int getY() {
        return (int) currentY;
    }

    public double getNextX() {
        return nextX;
    }

    public double getNextY() {
        return nextY;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Healthbar getHealthBar() {
        return healthbar;
    }

    public int getBiomolecule() {
        return biomolecule;
    }

    public int getCounter() {
        return counter;
    }

    public boolean pathIsFinished() {
        return pathFinished;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setNextX(double nextX) {
        this.nextX = nextX;
    }

    public void setNextY(double nextY) {
        this.nextY = nextY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


}
