package com.example.geektrust.service;

import com.example.geektrust.dto.Location;
import com.example.geektrust.exception.UserException;
import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Rider;
import com.example.geektrust.repo.UserRepo;

import java.util.List;

public class UserService {
    private static volatile UserService instance;
    private final UserRepo userRepo;

    private UserService() {
        this.userRepo = new UserRepo();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null)
                    instance = new UserService();
            }
        }
        return instance;
    }

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

    public void createDriver(String[] driverDetails) {
        if (driverDetails.length != 3)
            throw new IllegalArgumentException("Driver details insufficient");

        String driverId = driverDetails[0];
        if (userRepo.getDriverById(driverId).isPresent())
            throw new UserException("Driver with same id already exist");

        int xCoordinates = Integer.parseInt(driverDetails[1]);
        int yCoordinates = Integer.parseInt(driverDetails[2]);
        Driver driver = new Driver(driverId, new Location(xCoordinates, yCoordinates));

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
        Rider rider = new Rider(riderId, new Location(xCoordinates, yCoordinates));

        userRepo.addRider(rider);
    }
}
