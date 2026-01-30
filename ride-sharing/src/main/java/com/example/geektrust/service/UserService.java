package com.example.geektrust.service;

import com.example.geektrust.exception.UserException;
import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Rider;
import com.example.geektrust.repo.UserRepo;

import java.util.List;

public class UserService {
    private final UserRepo userRepo = new UserRepo();

    public List<Driver> getDrivers() {
        return userRepo.getDrivers();
    }

    public List<Rider> getRiders() {
        return userRepo.getRiders();
    }

    public void createDriver(String[] driverDetails) {
        if (driverDetails.length != 3)
            throw new IllegalArgumentException("Driver details insufficient");

        String driverId = driverDetails[0];
        if (userRepo.getDriverById(driverId).isPresent())
            throw new UserException("Driver with same id already exist");

        int xCoordinates = Integer.parseInt(driverDetails[1]);
        int yCoordinates = Integer.parseInt(driverDetails[2]);
        int[] coordinates = new int[] {xCoordinates, yCoordinates};

        Driver driver = new Driver(driverId, coordinates);
        userRepo.addDriver(driver);
    }

    public void createRider(String[] riderDetails) {
        if (riderDetails.length != 3)
            throw new IllegalArgumentException("Driver details insufficient");

        String riderId = riderDetails[0];
        if (userRepo.getDriverById(riderId).isPresent())
            throw new UserException("Rider with same id already exist");

        int xCoordinates = Integer.parseInt(riderDetails[1]);
        int yCoordinates = Integer.parseInt(riderDetails[2]);
        int[] coordinates = new int[] {xCoordinates, yCoordinates};

        Rider rider = new Rider(riderId, coordinates);
        userRepo.addRider(rider);
    }
}
