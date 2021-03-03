package com.example.gameforclass.background;

import com.example.gameforclass.antigens.Species;

import java.util.TreeMap;

public class Campaign {

    private Species[][] matrix;
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
            matrix = new Species[][]
                    {       //1-0
                            {Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //2-3
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //3-8
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //4-16
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //5-26
                            {Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //6-36
                            {Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.ASPERGILLUS},
                            //7-49
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //8-67
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //9-70
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //10-73
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //11-76
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //12-79
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //13-82
                            {Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS},
                            //14-85
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //15-86
                            {Species.TUBERCULOSIS},
                            //16
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //17
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //18
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //19
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //20
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //21
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //22
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //23
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //24
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //25
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //26
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //27
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //28
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //29
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //30
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //31
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //32
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //33
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //34
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //35
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //36
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //37
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //38
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //39
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //40
                            {Species.CORONAVIRUS},

                    };
        } else if (difficulty == 2) {
            multiplier = 1.1;
            matrix = new Species[][]
                    {
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                    };
        } else {
            multiplier = 1.3;
            matrix = new Species[][]
                    {
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, null, null, null, null, null, null, null},
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

    public Species[] getCurrentArray() {
        return matrix[currentArray];
    }

    public int getWaitTime() {
        return waitTime;
    }


}
