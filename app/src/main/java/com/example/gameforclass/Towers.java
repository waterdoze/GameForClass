package com.example.gameforclass;

public class Towers extends Entity{

    private int cost;
    private int refund;
    private double range;

    public Towers(int x, int y, int cost, int refund, double range) {
        super(x, y, 0);
        this.cost = cost;
        this.refund = refund;
        this.range = range;
    }

}
