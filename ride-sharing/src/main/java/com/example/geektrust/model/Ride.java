package com.example.geektrust.model;

public class Ride {
    private final String id;
    private final Rider rider;
    private final Driver driver;
    private final int[] originCoordinates;
    private int[] destinationCoordinates;
    private int timeTake;
    private Bill bill;

    public Ride(String id, Rider rider, Driver driver, int[] originCoordinates) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.originCoordinates = originCoordinates;
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

    public int[] getOriginCoordinates() {
        return originCoordinates;
    }

    public int getTimeTake() {
        return timeTake;
    }

    public void setTimeTake(int timeTake) {
        this.timeTake = timeTake;
    }

    public int[] getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public void setDestinationCoordinates(int[] destinationCoordinates) {
        this.destinationCoordinates = destinationCoordinates;
    }
}
