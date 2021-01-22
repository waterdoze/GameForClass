package com.example.gameforclass.towers;

import com.example.gameforclass.antigens.Antigen;

public class Towers {

    private int cost;
    private int refund;
    private int power;
    private double range;
    private double towerX, towerY;

    public void Towers(int cost, int refund, int power, double range) {
        this.cost = cost;
        this.refund = refund;
        this.power = power;
        this.range = range;
    }

    public void shoot(Antigen target) {
        if (isHittable(target)) {
            target.takeDamage(power);
        }
    }

    public boolean isHittable(Antigen target) {
        double comparedX = Math.abs(target.getX() - towerX);
        double comparedY = Math.abs(target.getY() - towerY);

        return Math.sqrt(Math.pow(comparedX, 2) + Math.pow(comparedY, 2)) <= range;
    }

    
}
