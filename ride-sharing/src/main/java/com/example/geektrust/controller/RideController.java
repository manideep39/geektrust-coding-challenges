package com.example.geektrust.controller;

import com.example.geektrust.application.service.RideService;
import com.example.geektrust.exception.RideException;
import com.example.geektrust.exception.UserException;

import java.util.List;
import java.util.stream.Collectors;

public class RideController {
    private final RideService rideService = RideService.getInstance();

    public void match(String[] details) {
        String riderId = details[0];
        try {
            String output = rideService.match(riderId);
            System.out.println(output);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startRide(String[] details) {
        String rideId = details[0];
        int nThDriver = Integer.parseInt(details[1]);
        String riderId = details[2];
        try {
            String output = rideService.startRide(rideId, nThDriver, riderId);
            System.out.println(output);
        } catch (RideException e) {
            System.out.println(e.getMessage());
        }
    }
}
