package com.example.gameforclass.antigens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Entity;
import com.example.gameforclass.Healthbar;
import com.example.gameforclass.Map;
import com.example.gameforclass.R;
import com.example.gameforclass.TowerDefensePog;

import java.util.ArrayList;

public class Antigen extends Entity {



    private int health, maxHealth, biomolecule;
    public int velocity;
    private double currentX, currentY, nextX, nextY;
    private int gear = 0, counter = 2, margin = 2;
    public int dy, dx;

    public boolean pathFinished = false;

    private int screenX, screenY; //SIZE OF THE FRAGMENT

    private EnemyType type;
    private Map map;
    private ArrayList<Double> path;
    private Healthbar healthbar;

    public Antigen(Context context, TowerDefensePog TDP, int health, int biomolecule, int velocity, EnemyType type, int tileX, int tileY) {

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

        currentX = path.get(0);
        currentY = path.get(1);
        nextX = path.get(counter);
        nextY = path.get(counter + 1);
        counter += 2;

    }


    public EnemyType getType() {
        return type;
    }


    public int getBiomolecule() {
        return biomolecule;
    }


    public void takeDamage(int damage) {

        health -= damage;
        if(health < 0) health = 0;
    }

    public int getX() {
        return (int) currentX;
    }

    public int getY() {
        return (int) currentY;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Healthbar getHealthbar() {
        return healthbar;
    }

    public void move() {

        if(pathFinished) return;

        double changeX;
        double changeY;

        if (!(Math.abs(currentX - nextX) < margin && Math.abs(currentY - nextY) < margin)){
            if (Math.abs(currentX - nextX) < margin && Math.abs(currentY - nextY) > margin) {
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
            } else if (Math.abs(currentY - nextY) < margin && Math.abs(currentX - nextX) > margin) {
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
            } else if (!(Math.abs(currentX - nextX) < margin) && !(Math.abs(currentY - nextY) < margin)) {

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
}
