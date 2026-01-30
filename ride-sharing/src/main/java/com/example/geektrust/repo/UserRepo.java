package com.example.geektrust.repo;

import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Rider;

import java.util.*;

public class UserRepo {
    private final List<Driver> drivers;
    private final List<Rider> riders;

    public UserRepo() {
        drivers = new ArrayList<>();
        riders = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRider(Rider rider) {
        riders.add(rider);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public Optional<Rider> getRiderById(String riderId) {
        return riders.stream()
                .filter(rider -> rider.getId().equals(riderId))
                .findAny();
    }

    public Optional<Driver> getDriverById(String riderId) {
        return drivers.stream()
                .filter(driver -> driver.getId().equals(riderId))
                .findAny();
    }


}
