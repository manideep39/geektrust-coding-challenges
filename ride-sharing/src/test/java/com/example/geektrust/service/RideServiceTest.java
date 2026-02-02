package com.example.geektrust.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideServiceTest {

    RideService rideService;
    UserService userService;

    @BeforeEach
    void setUp() {
        rideService = RideService.getInstance();
        userService = UserService.getInstance();
    }

    @Test
    void match() {
        /*
        ADD_DRIVER D1 1 1
        ADD_DRIVER D2 4 5
        ADD_DRIVER D3 2 2
        ADD_RIDER R1 0 0
        ADD_RIDER R1 0 0
         */
        String[] matchDetails = new String[] {"R1"};
        String[] riderDetails1 = new String[] { "R1", "2", "4"};
        String[] driverOneDetails = new String[] { "D1", "1", "1"};
        String[] driverTwoDetails = new String[] { "D2", "4", "5"};
        String[] driverThirdDetails = new String[] { "D3", "2", "2"};
        String[] driverFourDetails = new String[] { "D4", "10", "10"};

        userService.createRider(riderDetails1);

        userService.createDriver(driverOneDetails);
        userService.createDriver(driverTwoDetails);
        userService.createDriver(driverThirdDetails);
        userService.createDriver(driverFourDetails);

        rideService.match(matchDetails);
    }
}