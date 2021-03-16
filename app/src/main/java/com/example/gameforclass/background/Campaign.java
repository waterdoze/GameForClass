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
        timeMap.put(104, 30);
        timeMap.put(105, 4);
        timeMap.put(107, 30);
        timeMap.put(108, 4);
        timeMap.put(110, 30);
        timeMap.put(111, 4);
        timeMap.put(113, 30);
        timeMap.put(114, 4);
        timeMap.put(116, 30);
        timeMap.put(117, 4);
        timeMap.put(119, 30);
        timeMap.put(120, 4);
        timeMap.put(122, 30);
        timeMap.put(123, 4);
        timeMap.put(125, 30);
        timeMap.put(126, 4);
        timeMap.put(128, 30);
        timeMap.put(131, 10);
        timeMap.put(137, 15);
        timeMap.put(141, 30);
        timeMap.put(155, 15);
        timeMap.put(157, 30);
        timeMap.put(162, 8);
        timeMap.put(182, 4);
        timeMap.put(211, 20);
        timeMap.put(226, 4);
        timeMap.put(232, 20);
        timeMap.put(232, 20);
        timeMap.put(233, 35);
        timeMap.put(235, 4);
        timeMap.put(245, 35);
        timeMap.put(245, 35);
        timeMap.put(246, 15);
        timeMap.put(251, 4);
        timeMap.put(260, 35);
        timeMap.put(261, 20);
        timeMap.put(269, 15);
        timeMap.put(303, 20);
        timeMap.put(308, 4);
        timeMap.put(317, 20);
        timeMap.put(324, 4);
        timeMap.put(333, 20);
        timeMap.put(336, 40);
        timeMap.put(352, 60);
        timeMap.put(352, 60);
        timeMap.put(356, 2);
        timeMap.put(451, 45);
        timeMap.put(453, 25);

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
                            //11-128
                            {Species.TUBERCULOSIS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.RHINOVIRUS},
                            //12-137
                            {Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.TUBERCULOSIS, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA},
                            //13-162
                            {Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS},
                            //14-182
                            {Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.RHINOVIRUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //15-211
                            {Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA},
                            //16-220
                            {Species.TUBERCULOSIS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS},
                            //17-232
                            {Species.STAPHYLOCOCCUS},
                            //18-233
                            {Species.STAPHYLOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.STAPHYLOCOCCUS},
                            //19-261
                            {Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.TUBERCULOSIS, Species.INFLUENZA, Species.INFLUENZA, Species.INFLUENZA, Species.STAPHYLOCOCCUS},
                            //20-269
                            {Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.RHINOVIRUS, Species.STAPHYLOCOCCUS},
                            //21-303
                            {Species.INFLUENZA, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.TUBERCULOSIS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.INFLUENZA, Species.STAPHYLOCOCCUS, Species.INFLUENZA, Species.RHINOVIRUS, Species.ASPERGILLUS, Species.TUBERCULOSIS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.PNEUMOCOCCUS, Species.INFLUENZA, Species.STAPHYLOCOCCUS, Species.TUBERCULOSIS},
                            //22-336
                            {Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.STAPHYLOCOCCUS, Species.TUBERCULOSIS, Species.TUBERCULOSIS, Species.TUBERCULOSIS},
                            //23-352
                            {Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX, Species.ANTHRAX},
                            //24-451
                            {Species.CORONAVIRUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS, Species.ASPERGILLUS},
                            //25
                            {Species.SPANISH_FLU}

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
