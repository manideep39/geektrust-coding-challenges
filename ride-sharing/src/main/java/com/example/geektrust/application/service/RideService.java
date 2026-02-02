package com.example.geektrust.application.service;

import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.service.DriverMatchingPolicy;
import com.example.geektrust.domain.service.RideDomainService;
import com.example.geektrust.exception.RideException;
import com.example.geektrust.exception.UserException;
import com.example.geektrust.domain.service.DistanceCalculator;
import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.repository.RideRepo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RideService {
    private final RideRepo rideRepo = RideRepo.getInstance();
    private final UserService userService = UserService.getInstance();
    private final Logger logger = Logger.getLogger(RideService.class.getName());
    private final DriverMatchingPolicy driverMatchingPolicy = new DriverMatchingPolicy(new DistanceCalculator());
    private final RideDomainService rideDomainService = new RideDomainService();

    private RideService() {}

    private static class Holder {
        private static final RideService INSTANCE = new RideService();
    }

    public static RideService getInstance() {
        return Holder.INSTANCE;
    }

    public String startRide(String rideId, int nThDriver, String riderId) {
        Rider rider = userService.getRiderById(riderId);
        Ride ride = rideDomainService.startRide(rideId, nThDriver, rider);
        rideRepo.saveRide(ride);
        return "RIDE_STARTED " + rideId;
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
}
