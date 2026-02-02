package com.example.geektrust.model;

import com.example.geektrust.dto.Location;

public final class Driver extends User {
    private boolean inRide;

    public Driver(String id, Location location) {
        super(id, location);
    }

    public boolean isInRide() {
        return inRide;
    }

    public void setInRide(boolean inRide) {
        this.inRide = inRide;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "inRide=" + inRide +
                "} " + super.toString();
    }
}
