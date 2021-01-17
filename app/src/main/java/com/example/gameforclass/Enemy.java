package com.example.gameforclass;

import android.view.View;
import android.widget.ImageView;

class Enemy {

    public enum EnemyType {
        VIRUS, FUNGI, BACTERIA
    }

    private String name;
    private ImageView image;
    private int health, biomolecule;
    private EnemyType type;

    public Enemy(String name, int health, int biomolecule, EnemyType type) {
        this.name = name;
        this.health = health;
        this.biomolecule = biomolecule;
        this.type = type;
    }

    public void destroy() {
        image.setVisibility(View.GONE);
    }

     public EnemyType getType() {
        return type;
     }

     public int getBiomolecule() {
        return biomolecule;
     }

     public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            destroy();
        }
     }


}
