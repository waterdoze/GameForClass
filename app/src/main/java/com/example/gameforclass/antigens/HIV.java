package com.example.gameforclass.antigens;

import android.content.Context;

import com.example.gameforclass.EnemyType;
import com.example.gameforclass.Map;
import com.example.gameforclass.TowerDefensePog;
import com.example.gameforclass.antigens.Antigen;

public class HIV extends Antigen {

    public HIV(Context context, TowerDefensePog TDP) {
        super(context, TDP, 200, 100, EnemyType.HIV, 30, 100);
    }

}
