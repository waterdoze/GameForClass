package com.example.gameforclass.enemies;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.gameforclass.Healthbar;
import com.example.gameforclass.Map;
import com.example.gameforclass.R;

import java.util.ArrayList;

public class Enemy {

    public enum EnemyType {
        VIRUS, FUNGI, BACTERIA
    }

    private int health, maxHealth, biomolecule, velocity;
    private double currentX, currentY, nextX, nextY;
    private int gear = 0, counter = 2, margin = 2;

    private EnemyType type;
    private Bitmap unit;
    private Map map;
    private ArrayList<Double> path;
    private Healthbar healthbar;

    public Enemy(Context context, Map map, int health, int biomolecule, EnemyType type) {

        this.unit = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.aspergillus), 120, 120, false);
        this.map = map;
        this.health = health;
        this.biomolecule = biomolecule;
        this.type = type;

        maxHealth = health;
        velocity = 12;

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

        if (health <= 0) {

        }
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

    public Bitmap getImage() {
        return unit;
    }

    public Healthbar getHealthbar() {
        return healthbar;
    }

    public void move() {

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
        }
    }
}