package com.example.gameforclass.cells;

import java.util.ArrayList;

public class Upgrade {

    private ArrayList<Tower> array;

    public Upgrade(ArrayList<Tower> array) {
        this.array = array;

    }

    private void improve(UpgradeType upgrade) {

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
