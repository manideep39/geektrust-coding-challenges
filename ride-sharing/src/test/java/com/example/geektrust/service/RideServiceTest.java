package com.example.geektrust.service;

import com.example.geektrust.domain.valueobject.Location;
import org.junit.jupiter.api.Test;

class RideServiceTest {

    RideService rideService = new RideService();
    UserService userService = new UserService();

    @Test
    void match() {
        userService.createRider("R1", new Location(2, 4));
        userService.createDriver("D1", new Location(1, 1));
        userService.createDriver("D2", new Location(4, 5));
        userService.createDriver("D3", new Location(2, 2));
        userService.createDriver("D4", new Location(10, 10));
        userService.createDriver("D5", new Location(7, 7));

        rideService.match("R1");
    }
}