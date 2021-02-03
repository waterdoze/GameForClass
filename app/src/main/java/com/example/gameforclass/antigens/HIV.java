package com.example.gameforclass.antigens;

import android.content.Context;

import com.example.gameforclass.background.TowerDefensePog;

public class HIV extends Antigen {

    public HIV(Context context, TowerDefensePog TDP) {
        super(context, TDP, 200, 100, 15, AntigenType.HIV, 30, 100);
    }

}
