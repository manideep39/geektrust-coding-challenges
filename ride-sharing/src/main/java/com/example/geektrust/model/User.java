package com.example.geektrust.model;

import com.example.geektrust.dto.Location;

public sealed class User permits Driver, Rider {
    private final String id;
    private Location location;

    public User(String id, Location location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", location=" + location +
                '}';
    }
}
