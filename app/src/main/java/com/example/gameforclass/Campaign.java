package com.example.gameforclass;

import com.example.gameforclass.antigens.Antigen;
import com.example.gameforclass.antigens.Aspergillus;

public class Campaign {

    private EnemyType[][] matrix;
    private int waitTime;
    private int currentArray;
    private double multiplier;

    public Campaign(int difficulty) {

        waitTime = 30;
        currentArray = 0;
        matrix = new EnemyType[10][10];

        if (difficulty == 1) {
            multiplier = 1;
             matrix = new EnemyType[][]
                     {
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.HIV, EnemyType.HIV, EnemyType.HIV, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                     };
        }
        else if (difficulty == 2) {
            multiplier = 1.1;
            matrix = new EnemyType[][]
                    {
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                    };
        }
        else {
            multiplier = 1.3;
            matrix = new EnemyType[][]
                    {
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, EnemyType.ASPERGILLUS, null, null, null, null, null, null, null},
                    };
        }
    }

    public int getWaitTime() {
        int result = waitTime;
        updateWaitTime();
        return result;
    }

    private void updateWaitTime() {
    }

    public EnemyType[] getCurrentArray() {
        return matrix[currentArray];
    }

    public void setNextRound() {
        currentArray++;
    }
}
