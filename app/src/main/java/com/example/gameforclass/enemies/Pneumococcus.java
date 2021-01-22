package com.example.gameforclass.enemies;

import android.content.Context;

import com.example.gameforclass.Map;
import com.example.gameforclass.antigens.Antigen;

public class Pneumococcus extends Antigen {

    public Pneumococcus(Context context, Map map) {
        super(context, map, 100, 5, EnemyType.BACTERIA, 30, 100);
    }

}
