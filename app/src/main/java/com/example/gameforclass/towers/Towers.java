package com.example.gameforclass.towers;

import com.example.gameforclass.enemies.Enemy;

public class Towers {

    private int cost;
    private int refund;
    private int power;
    private double range;

    public void Towers(int cost, int refund, int power, double range) {
        this.cost = cost;
        this.refund = refund;
        this.power = power;
        this.range = range;
    }

    public void shoot(Enemy target) {
        if (isHittable(target)) {
            target.takeDamage(power);
        }
    }

    public boolean isHittable(Enemy target) {
        return true;
    }
}
