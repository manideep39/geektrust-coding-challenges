package com.example.geektrust.domain.service;

import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.exception.RideException;
import com.example.geektrust.repository.RideRepo;

import java.util.List;

public class RideDomainService {
    private final RideRepo rideRepo = RideRepo.getInstance();

    public Ride startRide(String rideId, int nThDriver, Rider rider) {
        if (rideRepo.getRideById(rideId).isPresent())
            throw new RideException("INVALID_RIDE");

        List<Driver> matchedDrivers = rideRepo.getMatchedDriversForRider(rider);
        Driver driver = selectNthDriver(matchedDrivers, nThDriver);
        driver.startRide();

        return Ride.start(rideId, rider, driver);
    }

    private Driver selectNthDriver(List<Driver> drivers, int n) {
        if (drivers.size() < n)
            throw new RideException("INVALID_RIDE");
        return drivers.get(n - 1);
    }
}
