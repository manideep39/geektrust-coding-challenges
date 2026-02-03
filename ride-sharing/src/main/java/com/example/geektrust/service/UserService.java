package com.example.geektrust.service;

import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.UserException;
import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.repository.UserRepo;

import java.util.List;

public class UserService {
    private final UserRepo userRepo = UserRepo.getInstance();

    public List<Driver> getDrivers() {
        return userRepo.getDrivers();
    }

    public List<Rider> getRiders() {
        return userRepo.getRiders();
    }

    public Rider getRiderById(String riderId) {
        return userRepo.getRiderById(riderId)
                .orElseThrow(() -> new UserException("RIDER NOT FOUND"));
    }

    public void createDriver(String driverId, Location location) {
        if (userRepo.getDriverById(driverId).isPresent())
            throw new UserException("Driver with same id already exist");

        var driver = new Driver(driverId, location);
        userRepo.addDriver(driver);
    }

    public void createRider(String riderId, Location location) {
        if (userRepo.getDriverById(riderId).isPresent())
            throw new UserException("Rider with same id already exist");

        var rider = new Rider(riderId, location);
        userRepo.addRider(rider);
    }
}
