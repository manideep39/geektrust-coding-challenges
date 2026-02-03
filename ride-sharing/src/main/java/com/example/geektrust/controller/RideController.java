package com.example.geektrust.controller;

import com.example.geektrust.application.service.RideService;
import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.RideException;
import com.example.geektrust.exception.UserException;

public class RideController {
    private final RideService rideService = RideService.getInstance();

    public void match(String[] details) {
        try {
            String riderId = details[0];
            String output = rideService.match(riderId);
            System.out.println(output);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough details in MATCH command");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startRide(String[] details) {
        try {
            String rideId = details[0];
            int nThDriver = Integer.parseInt(details[1]);
            String riderId = details[2];
            String output = rideService.startRide(rideId, nThDriver, riderId);
            System.out.println(output);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough details in START_RIDE command");
        } catch (RideException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stopRide(String[] details) {
        try {
            String rideId = details[0];
            Location location = new Location(
                    Integer.parseInt(details[1]),
                    Integer.parseInt(details[2])
            );
            int timeTaken = Integer.parseInt(details[3]);
            String output = rideService.stopRide(rideId, location, timeTaken);
            System.out.println(output);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough details in STOP_RIDE command");
        } catch (RideException e) {
            System.out.println(e.getMessage());
        }
    }
}
