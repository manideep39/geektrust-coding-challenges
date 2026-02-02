package com.example.geektrust.domain.model;

import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.RideException;

public final class Driver extends User {
    private boolean inRide;

    public Driver(String id, Location location) {
        super(id, location);
    }

    public boolean isInRide() {
        return inRide;
    }

    public void startRide() {
        if (inRide)
            throw new RideException("RIDE_IN_PROGRESS");
        inRide = true;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "inRide=" + inRide +
                "} " + super.toString();
    }
}
