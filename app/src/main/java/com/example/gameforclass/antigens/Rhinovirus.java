package com.example.gameforclass.antigens;

import android.content.Context;

import com.example.gameforclass.background.TowerDefensePog;

public class Rhinovirus extends Antigen {

    public Rhinovirus(Context context, TowerDefensePog TDP) {
        super(context, TDP, 200, 100, 15, AntigenType.RHINOVIRUS, 30, 100);
    }

}
