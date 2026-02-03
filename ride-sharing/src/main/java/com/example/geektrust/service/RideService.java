package com.example.geektrust.service;

import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.service.DriverMatchingPolicy;
import com.example.geektrust.domain.service.RideDomainService;
import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.RideException;
import com.example.geektrust.exception.UserException;
import com.example.geektrust.domain.service.DistanceCalculator;
import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.repository.RideRepo;

import java.util.List;
import java.util.stream.Collectors;

public class RideService {
    private final RideRepo rideRepo = RideRepo.getInstance();
    private final UserService userService = new UserService();
    private final DriverMatchingPolicy driverMatchingPolicy = new DriverMatchingPolicy(new DistanceCalculator());
    private final RideDomainService rideDomainService = new RideDomainService();

    public Ride getRideById(String rideId) {
        return rideRepo.getRideById(rideId)
                .orElseThrow(() -> new RideException("INVALID_RIDE"));
    }

    public String match(String riderId) throws UserException {
        Rider rider = userService.getRiderById(riderId);
        List<Driver> drivers = userService.getDrivers();
        List<Driver> matchedDrivers = driverMatchingPolicy.selectMatches(rider, drivers);
        rideRepo.saveMatches(rider, matchedDrivers);
        return matchedDrivers.isEmpty() ?
                "NO_DRIVERS_AVAILABLE" :
                "DRIVERS_MATCHED " + matchedDrivers.stream()
                        .map(driver -> "DRIVER_" + driver.getId())
                        .collect(Collectors.joining(" "));
    }

    public String startRide(String rideId, int nThDriver, String riderId) {
        Rider rider = userService.getRiderById(riderId);
        Ride ride = rideDomainService.startRide(rideId, nThDriver, rider);
        rideRepo.saveRide(ride);
        return "RIDE_STARTED " + ride.getId();
    }

    public String stopRide(String rideId, Location location, int timeTaken) {
        Ride ride = rideDomainService.stopRide(rideId, location, timeTaken);
        rideRepo.saveRide(ride);
        return "RIDE_STOPPED " + ride.getId();
    }
}
