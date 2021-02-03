package com.example.gameforclass.background;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Map {

    private int height;
    private int width;
    private double slope;
    private String coordinates;
    private ArrayList<String> coordinateArray;
    private ArrayList<Double> solvedCoordinateArray;

    public Map(String coordinates, int width, int height) {
        this.height = height;
        this.width = width;
        this.coordinates = coordinates;
        setEnemyPath();
    }

    protected void setEnemyPath() {
        coordinateArray = new ArrayList<String>();
        Matcher m = Pattern.compile("\\(.*?\\)").matcher(coordinates);
        while (m.find()) {
            coordinateArray.add(m.group());
        }
        solvedCoordinateArray = new ArrayList<>();

        for (String s: coordinateArray) {
            double x = Double.parseDouble(s.substring(1, 6));
            double y = Double.parseDouble(s.substring(8, 13));
            solvedCoordinateArray.add(x * width * 1.06);
            solvedCoordinateArray.add(y * height);
        }
    }

    public ArrayList<Double> getSolvedCoordinateArray() {
        return solvedCoordinateArray;
    }

    public double createSlope(double x, double y) {
        slope = y / x;
        return slope;
    }
}
