package com.example.gameforclass.enemies;

import android.content.Context;

import com.example.gameforclass.Map;
import com.example.gameforclass.antigens.Antigen;

public class HIV extends Antigen {

    public HIV(Context context, Map map) {
        super(context, map, 200, 100, EnemyType.VIRUS, 30, 100);
    }

}
