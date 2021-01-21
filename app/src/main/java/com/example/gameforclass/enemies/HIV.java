package com.example.gameforclass.enemies;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.gameforclass.Map;

public class HIV extends Enemy {

    public HIV(Context context, Map map) {
        super(context, map, 200, 100, EnemyType.VIRUS);
    }

}
