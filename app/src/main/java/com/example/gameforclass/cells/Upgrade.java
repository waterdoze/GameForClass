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
            case FEVER:
                break;
            case AFFECT_NAIVE_CELL:
                for (Tower t: array) {
                    if (t.getTowerType() == TowerType.NAIVE_T_CELL) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case BONE_MARROW_UPGRADE:
                for (Tower t: array) {
                    if (t.getTowerType() == TowerType.MACROPHAGE) {
                        t.setDmg(t.getDmg() + 5);
                        t.setRange(t.getRange() + 50);
                    }
                }
                break;
            case NEUTROPHIL_TRANSFUSION:
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
