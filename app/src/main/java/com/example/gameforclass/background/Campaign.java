package com.example.gameforclass.background;

import com.example.gameforclass.antigens.AntigenType;

import java.util.TreeMap;

public class Campaign {

    private AntigenType[][] matrix;
    private int counter = 0;
    private int waitTime;
    private int currentArray;
    private TreeMap<Integer, Integer> timeMap = new TreeMap<>();
    //TODO utilize the multiplier for difficulty
    private double multiplier;

    public Campaign(int difficulty) {

        timeMap.put(10, 25);
        timeMap.put(33, 5);
        timeMap.put(45, 25);
        timeMap.put(46, 5);

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
                             {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS},
                             {AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS},
                             {AntigenType.TUBERCULOSIS, AntigenType.ASPERGILLUS, null, null, null, null, null, null, null, null},
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



    public void updateWaitTime() {
        counter++;
        if (timeMap.containsKey(counter)) {
            waitTime = timeMap.get(counter);
        }

    }

    public AntigenType[] getCurrentArray() {
        return matrix[currentArray];
    }

    public void setNextRound() {
        currentArray++;
    }
}
