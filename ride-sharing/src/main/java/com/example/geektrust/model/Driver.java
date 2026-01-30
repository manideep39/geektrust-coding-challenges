package com.example.geektrust.model;

public final class Driver extends User {
    private boolean inRide;

    public Driver(String id, int[] coordinates) {
        super(id, coordinates);
    }

    public boolean isInRide() {
        return inRide;
    }

    public void setInRide(boolean inRide) {
        this.inRide = inRide;
    }
}
