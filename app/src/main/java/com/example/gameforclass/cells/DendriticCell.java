package com.example.gameforclass.cells;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.gameforclass.R;
import com.example.gameforclass.animation.AttackPellet;
import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.background.TowerDefensePog;

import java.util.ArrayList;

public class DendriticCell extends Tower {

    private boolean phase = false, pathFinished = false;
    private int nextX, nextY;
    private int velocity = 5;
    private TCell chosen;
    private Antigen target;

    public DendriticCell(int tileX, int tileY, TowerDefensePog TDP) {
        super(tileX, tileY, 50, 0, 80, 0, false, TowerType.DENDRITIC_CELL, 1);

        Bitmap img = BitmapFactory.decodeResource(TDP.getResources(), R.drawable.dendritic);

        img = Bitmap.createScaledBitmap(img, TDP.TILE_WIDTH, TDP.TILE_HEIGHT, false);
        setImage(img);
    }

    @Override
    public boolean attack(ArrayList<Antigen> enemies, ArrayList<Tower> towers) {
//        if (phase) {
//            if (pathFinished) {
//                towers.remove(this);
//                chosen.ascend();
//                return false;
//            }
//            move();
//            return false;
//        }
//        Antigen target = null;
//        double d = 0;
//
//          if(enemies.isEmpty()) return false;
//
//        for (Antigen a: enemies) {
//            d = distanceTo(a);
//            if (target == null && d <= getRange()) { //if there's no target yet, set it to any target
//                target = a;                   //set to closest target in enemies list
//            }
//            else if (d <= getRange() && target != null && d < distanceTo(target)) target = a;
//        }
//        if(target == null) {
//            return false;
//        }


//        target.takeDamage(100);
//        if (target.getHealth() == 0) {
//
//            ActivationPhase(towers);
//        }
//        else {
//            towers.remove(this);
//        }
        //if an enemy is in range, attack
        //attackPellet = new AttackPellet(tileX*TowerDefensePog.TILE_WIDTH + TowerDefensePog.TILE_WIDTH/2, tileY*TowerDefensePog.TILE_HEIGHT + TowerDefensePog.TILE_HEIGHT/2, target.posX, target.posY, dmg);
        return true;
    }

    public boolean grabCell(ArrayList<Antigen> enemies, ArrayList<Tower> towers, TowerDefensePog TDP)
    {
        if (phase) {
            if (pathFinished) {
                towers.remove(this);

                return false;
            }
            move();
            return false;
        }
        if(target != null) target = null;
        double d = 0;

        if(enemies.isEmpty()) return false;

        for (Antigen a: enemies) {
            d = distanceTo(a);
            if (target == null && d <= getRange()) { //if there's no target yet, set it to any target
                target = a;                   //set to closest target in enemies list
            }
            else if (d <= getRange() && target != null && d < distanceTo(target)) target = a;
        }
        if(target == null) {
            return false;
        }

        phase = true;
        target.takeDamage(50);

        nextX = TDP.screenX;
        nextY = 0;

        TDP.inventory.add(target.getType());
        return true;
    }

    private void move() {
        if(pathFinished) return;

        double changeX;
        double changeY;

        if (!(posX == nextX && posY == nextY)){

            if (posX == nextX && posY != nextY) {

                if (nextY < posY) {
                    changeY = -1 * velocity;
                    posY += changeY;
                    if (posY < nextY) {
                        posY = nextY;
                    }

                }
                else {
                    changeY = velocity;
                    posX += changeY;
                    if (posY > nextY) {
                        posY = nextY;
                    }
                }
            } else if (posY == nextY && posX != nextX) {

                if (nextX < posX) {
                    changeX = -1 * velocity;
                    posX += changeX;
                    if (posX < nextX) {
                        posX = nextX;
                    }
                }
                else {
                    changeX = velocity;
                    posX += changeX;
                    if (posX > nextX) {
                        posX = nextX;
                    }
                }
            } else if (!(posX == nextX) && !(posY == nextY)) {

                double slope = createSlope(nextX - posX, nextY - posY);
                changeX = Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1));
                changeY = Math.abs(slope * Math.sqrt(Math.pow(velocity, 2) / (Math.pow(slope, 2) + 1)));

                if (posX > nextX) {
                    posX -= changeX;
                    if (posX < nextX) {
                        posX = nextX;
                    }
                }
                if (posX < nextX) {
                    posX += changeX;
                    if (posX > nextX) {
                        posX = nextX;
                    }
                }
                if (posY > nextY) {
                    posY -= changeY;
                    if (posY < nextY) {
                        posY = nextY;
                    }
                }
                if (posY < nextY) {
                    posY += changeY;
                    if (posY > nextY) {
                        posY = nextY;
                    }
                }

            }
        }
        else {
            pathFinished = true;
        }

        setImageX();
        setImageY();

    }

    private void ActivationPhase(ArrayList<Tower> towers) {
        chosen = null;
        for (Tower t: towers) {
            if (t.getTowerType() == TowerType.NAIVE_T_CELL) {
                chosen = (TCell) t;
            }
        }
        if (chosen != null) {

            phase = true;
            nextX = chosen.getX();
            nextY = chosen.getY();
        }
        else {

            towers.remove(this);

        }

    }

    private double createSlope(double x, double y) {
        double slope = y / x;
        return slope;
    }


}
