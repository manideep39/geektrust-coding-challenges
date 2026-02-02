package com.example.geektrust.domain.model;

import com.example.geektrust.domain.valueobject.Location;

public final class Rider extends User {
    private boolean inRide;

    public Rider(String id, Location location) {
        super(id, location);
    }

    public boolean isInRide() {
        return inRide;
    }

    public void setInRide(boolean inRide) {
        this.inRide = inRide;
    }
}
