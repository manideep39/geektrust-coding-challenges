package com.example.geektrust.domain.model;

import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.RideException;

public class Ride {
    private final String id;
    private final Rider rider;
    private final Driver driver;
    private final Location origin;
    private Location destination;
    private int timeTaken;
    private Bill bill;

    public Ride(String id, Rider rider, Driver driver, Location origin) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.origin = origin;
    }

    public static Ride start(String id, Rider rider, Driver driver) {
        return new Ride(id, rider, driver, rider.getLocation());
    }

    public void stopRide(Location location, int timeTaken) {
        if (this.destination != null)
            throw new RideException("INVALID_RIDE");
        this.driver.stopRide();
        this.destination = location;
        this.timeTaken = timeTaken;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getOrigin() {
        return origin;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
