package com.example.geektrust.service;

import com.example.geektrust.exception.UserException;
import com.example.geektrust.model.DistanceCalculator;
import com.example.geektrust.model.Driver;
import com.example.geektrust.model.Rider;
import com.example.geektrust.repo.RideRepo;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class RideService {
    private final RideRepo rideRepo = RideRepo.getInstance();
    private final UserService userService = UserService.getInstance();
    private final Logger logger = Logger.getLogger(RideService.class.getName());
    private final int ALLOWED_DISTANCE_BETWEEN_DRIVER_AND_RIDER = 5;
    private final DistanceCalculator distanceCalculator = new DistanceCalculator();

    private RideService() {

    }

    private static class Holder {
        private static final RideService INSTANCE = new RideService();
    }

    public static RideService getInstance() {
        return Holder.INSTANCE;
    }

    public void match(String[] details) {
        /*
        look for drivers within 5km range & who are not inRide
        sort by ascending order of distance, same distance sort in lexi or driver ids
        print DRIVERS_MATCHED <DRIVER_ID1> <DRIVER_ID2> ... <DRIVER_ID5>

        if no drivers
        print ‘NO_DRIVERS_AVAILABLE’
         */

        String inputRiderId = details[0];
        try {
            Rider rider = userService.getRiderById(inputRiderId);
            List<Driver> matchedDrivers = userService.getDrivers().stream()
                    .filter(driver ->
                            (distanceCalculator.calculate(driver.getLocation(), rider.getLocation()) <= ALLOWED_DISTANCE_BETWEEN_DRIVER_AND_RIDER) && !driver.isInRide())
                    .sorted(Comparator.comparingDouble(driver -> distanceCalculator.calculate(driver.getLocation(), rider.getLocation())))
                    .toList();
            matchedDrivers.forEach(System.out::println);
        } catch (UserException e) {
            logger.severe(e.getMessage());
        }
    }
}
