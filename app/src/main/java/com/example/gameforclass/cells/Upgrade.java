package com.example.gameforclass.cells;

import java.util.ArrayList;

public class Upgrade {

    private ArrayList<Tower> array;
    private UpgradeType upgrade;

    public Upgrade(ArrayList<Tower> array, UpgradeType upgrade) {
        this.array = array;
        this.upgrade = upgrade;

        improve();
    }

    private void improve() {

        switch (upgrade) {
            case VACCINE_INJECTION:
                break;
            case OMEGA_RANGE:
                break;
            case MRNA_VACCINE_INJECTION:
                break;
        }
    }
}
