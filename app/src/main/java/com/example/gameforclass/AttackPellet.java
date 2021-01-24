package com.example.gameforclass;

public class AttackPellet {
    int dx;
    int dy;
    int screenX;
    int screenY;
    int targetX;
    int targetY;
    int size;
    int acceptableError = 30;
    boolean hitEm = false;
    public AttackPellet(int screenX, int screenY, int targetX, int targetY, int dmg){
        this.screenX = screenX;
        this.screenY = screenY;
        this.targetX = targetX;
        this.targetY = targetY;
        this.size = dmg / 3;
        dx = (targetX - screenX)/7;
        dy = (targetY - screenY)/7;
    }

    public void move(){
        screenX+=dx;
        screenY+=dy;
        if(Math.abs(screenX - targetX) <= acceptableError || Math.abs(screenY - targetY) <= acceptableError){
            hitEm = true;
        }
    }
}
