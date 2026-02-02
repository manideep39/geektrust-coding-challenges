package com.example.geektrust.model;

import com.example.geektrust.dto.Location;

public class DistanceCalculator {

    public double calculate(Location l1, Location l2) {
        return Math.sqrt(
                Math.pow(l2.xCoordinates() - l1.xCoordinates(), 2) +
                Math.pow(l2.yCoordinates() - l1.yCoordinates(), 2)
        );
    }
}
