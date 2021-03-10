package com.example.gameforclass.background;

import com.example.gameforclass.antigens.Antigen;
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
        timeMap.put(50, 4);
        timeMap.put(85, 120);
        timeMap.put(87, 10);
        timeMap.put(90, 120);
        timeMap.put(92, 10);
        timeMap.put(95, 120);
        timeMap.put(97, 10);
        timeMap.put(100, 20);
        timeMap.put(101, 4);
        timeMap.put(101, 4);
        timeMap.put(1, 4);

        waitTime = 30;
        currentArray = 0;

        if (difficulty == 1) {
            multiplier = 1;
            matrix = new Species[][]
                    {       //1-0
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
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
                            {Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //8-85
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //9-100
                            {Species.RHINOVIRUS},
                            //10-101
                            {Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS},
                            //11-130
                            {Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS},
                            //12
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //13
                            {Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS},
                            //14
                            {Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //15
                            {Species.SPANISH_FLU},
                            //16
                            {Species.TUBERCULOSIS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //17
                            {Species.SPANISH_FLU, Species.SPANISH_FLU, Species.SPANISH_FLU},
                            //18
                            {Species.STAPHYLOCOCCUS},
                            //19
                            {Species.STAPHYLOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS, Species.SPANISH_FLU, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS},
                            //20
                            {Species.SPANISH_FLU, Species.SPANISH_FLU, Species.SPANISH_FLU, Species.SPANISH_FLU, Species.SPANISH_FLU},
                            //21
                            {Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS},
                            //22
                            {Species.SPANISH_FLU, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.TUBERCULOSIS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS, Species.SPANISH_FLU, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.TUBERCULOSIS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS},
                            //23
                            {Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.TUBERCULOSIS},
                            //24
                            {Species.ASPERGILLUS, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX},
                            //25
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
        for (int i = 0; i < addition; i++) {
            counter++;
            if (timeMap.containsKey(counter)) {
                waitTime = timeMap.get(counter);
            }
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
