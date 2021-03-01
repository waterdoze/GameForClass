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

        timeMap.put(6, 25);
        timeMap.put(19, 4);
        timeMap.put(31, 25);
        timeMap.put(32, 4);
        timeMap.put(37, 18);
        waitTime = 30;
        currentArray = 0;

        if (difficulty == 1) {
            multiplier = 1;
            matrix = new AntigenType[][]
                    {       //1-0
                            {AntigenType.RHINOVIRUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //2-3
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //3-8
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //4-16
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS},
                            //5-26
                            {AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS},
                            //6-36
                            {AntigenType.TUBERCULOSIS},
                            //7-37
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //8-55
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //9-58
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //10-61
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //11-64
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //12-67
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //13-70
                            {AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS}
                    };
        } else if (difficulty == 2) {
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
        } else {
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



    public void updateWaitTime() {
        counter++;
        if (timeMap.containsKey(counter)) {
            waitTime = timeMap.get(counter);
        }

    }

    public void setPreviousRound() {
        currentArray--;
        if (currentArray < 0) {
            currentArray = 0;
        }
    }

    public void setNextRound() {
        currentArray++;
    }

    public int getRound() {
        return currentArray;
    }

    public AntigenType[] getCurrentArray() {
        return matrix[currentArray];
    }

    public int getWaitTime() {
        return waitTime;
    }


}
