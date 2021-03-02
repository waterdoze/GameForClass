package com.example.gameforclass.background;

import com.example.gameforclass.antigens.AntigenType;
import com.example.gameforclass.antigens.Tuberculosis;

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
        timeMap.put(20, 4);
        timeMap.put(31, 25);
        timeMap.put(32, 4);
        timeMap.put(36, 18);
        timeMap.put(37, 4);
        timeMap.put(40, 18);
        timeMap.put(41, 4);
        timeMap.put(44, 18);
        timeMap.put(45, 4);
        timeMap.put(48, 18);
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
                            {AntigenType.ASPERGILLUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.ASPERGILLUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.ASPERGILLUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.PNEUMOCOCCUS, AntigenType.ASPERGILLUS},
                            //7-49
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //8-67
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //9-70
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //10-73
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //11-76
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //12-79
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //13-82
                            {AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS, AntigenType.RHINOVIRUS},
                            //14-85
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //15-86
                            {AntigenType.TUBERCULOSIS},
                            //16
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //17
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //18
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //19
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //20
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //21
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //22
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //23
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //24
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //25
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //26
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //27
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //28
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //29
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //30
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //31
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //32
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //33
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //34
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //35
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //36
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //37
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //38
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //39
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},
                            //40
                            {AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS, AntigenType.ASPERGILLUS},

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

    public void updateWaitTime(int addition) {
        counter += addition;
        if (counter < 0) {
            counter = 0;
        }
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
