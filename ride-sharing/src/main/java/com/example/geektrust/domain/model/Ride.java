package com.example.geektrust.domain.model;

import com.example.geektrust.domain.service.DistanceCalculator;
import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.RideException;

public class Ride {
    private final String id;
    private final Rider rider;
    private final Driver driver;
    private final Location origin;
    private Location destination;
    private int timeTaken;
    private RideStatus status = RideStatus.IN_PROGRESS;

    private Ride(String id, Rider rider, Driver driver, Location origin) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.origin = origin;
    }

    public static Ride start(String id, Rider rider, Driver driver) {
        return new Ride(id, rider, driver, rider.getLocation());
    }

    public void stopRide(Location location, int timeTaken) {
        if (this.status != RideStatus.IN_PROGRESS)
            throw new RideException("INVALID_RIDE");
        this.status = RideStatus.ENDED;
        this.driver.stopRide();
        this.destination = location;
        this.timeTaken = timeTaken;
    }

    public boolean isRideEnded() {
        return status == RideStatus.ENDED;
    }

    public double getRideDistance(DistanceCalculator distanceCalculator) {
        return distanceCalculator.calculate(origin, destination);
    }

    public String getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getTimeTaken() {
        return timeTaken;
    }
}
