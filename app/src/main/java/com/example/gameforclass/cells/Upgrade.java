package com.example.gameforclass.cells;

import java.util.ArrayList;

public class Upgrade {

    private ArrayList<Tower> array;

    public Upgrade() {

    }

    public void insertTowerArray(ArrayList<Tower> array) {
        this.array = array;
    }

    public void improve(UpgradeType upgrade) {

        switch (upgrade) {
            case AFFECT_NAIVE_CELL:
                for (Tower t: array) {
                    if (t.getTowerType() == TowerType.CYTOTOXICTCELL) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case AFFECT_MACROPHAGE:
                for (Tower t: array) {
                    if (t.getTowerType() == TowerType.MACROPHAGE) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case AFFECT_NEUTROPHIL:
                for (Tower t: array) {
                    if (t.getTowerType() == TowerType.NEUTROPHIL) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
        }
    }
}
