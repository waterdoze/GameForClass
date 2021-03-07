package com.example.gameforclass.animation;

import com.example.gameforclass.background.TowerDefensePog;

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

    public AttackPellet(int screenX, int screenY, int targetX, int targetY, int dmg) {
        this.screenX = screenX + TowerDefensePog.TILE_WIDTH / 2;
        this.screenY = screenY + TowerDefensePog.TILE_HEIGHT / 2;
        this.targetX = targetX + TowerDefensePog.TILE_WIDTH / 2;
        this.targetY = targetY + TowerDefensePog.TILE_HEIGHT / 2;
        this.size = dmg;
        dx = (targetX - screenX) / 5;
        dy = (targetY - screenY) / 5;
    }

    public void move() {
        screenX += dx;
        screenY += dy;
        if (Math.abs(screenX - targetX) <= acceptableError || Math.abs(screenY - targetY) <= acceptableError) {
            hitEm = true;
        }
    }

    public int getX() {
        return screenX;
    }

    public int getY() {
        return screenY;
    }

    public int getSize() {
        return size;
    }

    public boolean hasHitEm() {
        return hitEm;
    }
}
