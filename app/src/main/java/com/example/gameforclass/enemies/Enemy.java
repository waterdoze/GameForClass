package com.example.gameforclass.enemies;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.gameforclass.Map;

import java.util.ArrayList;

public class Enemy {

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

        velocity = 12;

        path = map.getSolvedCoordinateArray();

        currentX = path.get(0);
        currentY = path.get(1);
        nextX = path.get(counter);
        nextY = path.get(counter + 1);
        counter += 2;

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

    public Bitmap getImage() {
        return unit;
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
                Log.d("margin1", "" + Math.abs(currentX));
                Log.d("margin2", "" + Math.abs(currentY));
                Log.d("next", "" + nextX);
                Log.d("next2", "" + nextY);
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

                Log.d("margin1", "" + Math.abs(currentX));
                Log.d("margin2", "" + Math.abs(currentY));
                Log.d("next", "" + nextX);
                Log.d("next2", "" + nextY);

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
