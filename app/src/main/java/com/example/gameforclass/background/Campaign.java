package com.example.gameforclass.background;

import com.example.gameforclass.antigens.AntigenType;

public class Campaign {

    private AntigenType[][] matrix;
    private int waitTime;
    private int currentArray;
    private double multiplier;

    public Campaign(int difficulty) {

        waitTime = 30;
        currentArray = 0;
        matrix = new AntigenType[10][10];

        if (difficulty == 1) {
            multiplier = 1;
             matrix = new AntigenType[][]
                     {
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.HIV, AntigenType.HIV, AntigenType.HIV, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                     };
        }
        else if (difficulty == 2) {
            multiplier = 1.1;
            matrix = new AntigenType[][]
                    {
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                    };
        }
        else {
            multiplier = 1.3;
            matrix = new AntigenType[][]
                    {
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null},
                    };
        }
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void randomWaitTime() {
        waitTime = (int)(5+Math.random()*50); //Wait time is random # of frames between 5 and 55
        if(Math.random() * 2 < 1.0) waitTime = (waitTime / 2) + 1; //half of the time, cut waitTime in half
    }

    public AntigenType[] getCurrentArray() {
        return matrix[currentArray];
    }

    public void setNextRound() {
        currentArray++;
    }
}
