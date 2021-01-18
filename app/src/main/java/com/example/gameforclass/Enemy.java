package com.example.gameforclass;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

class Enemy {

    public enum EnemyType {
        VIRUS, FUNGI, BACTERIA
    }

    private String name;
    private ImageView image;
    private int health, biomolecule, velocity;
    private double currentX, currentY, nextX, nextY;
    private EnemyType type;
    private Bitmap unit;
    private int gear = 0, counter = 2, margin = 2;

    Map map;
    ArrayList<Double> path;

    public Enemy(Bitmap unit, Map map, String name, int health, int biomolecule, EnemyType type) {
        this.unit = unit;
        this.map = map;
        this.name = name;
        this.health = health;
        this.biomolecule = biomolecule;
        this.type = type;

        velocity = 4;

        path = map.getSolvedCoordinateArray();

        currentX = path.get(0);
        currentY = path.get(1);
        nextX = path.get(counter);
        nextY = path.get(counter + 1);
        counter += 1;

    }

    public void destroy() {
        image.setVisibility(View.GONE);
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

    public int getX() {
        return (int) currentX;
    }

    public int getY() {
        return (int) currentY;
    }

    public void move() {
        double changeX;
        double changeY;
        if (!(Math.abs(currentX - nextX) < margin && Math.abs(currentY - nextY) < margin)){
            Log.d("margin1", "" + Math.abs(currentX));
            Log.d("margin2", "" + Math.abs(currentY));
            if (Math.abs(currentX - nextX) < margin && Math.abs(currentY - nextY) > margin) {
                if (nextY < currentY) {
                    changeY = -1 * velocity;

                }
                else {
                    changeY = velocity;

                }
                currentY += changeY;


            } else if (Math.abs(currentY - nextY) < margin && Math.abs(currentX - nextX) > margin) {
                if (nextX < currentX) {
                    changeX = -1 * velocity;

                }
                else {
                    changeX = velocity;

                }
                currentX += changeX;


            } else if (!(Math.abs(currentX - nextX) < margin) && !(Math.abs(currentY - nextY) < margin)) {
                double slope = map.createSlope(nextX - currentX, nextY - currentY);
                Log.d("slope", "" + slope);
                changeX = -1 *  Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1));
                changeY = -1 * Math.abs(slope * Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1)));
                currentX += changeX;
                currentY += changeY;

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
