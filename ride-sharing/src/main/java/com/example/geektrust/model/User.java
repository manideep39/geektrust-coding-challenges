package com.example.geektrust.model;

public sealed class User permits Driver, Rider {
    private final String id;
    private int[] coordinates;

    public User(String id, int[] coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
