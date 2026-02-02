package com.example.geektrust.domain.service;

import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.domain.valueobject.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverMatchingPolicyTest {

    @Test
    void selectMatches() {
        DriverMatchingPolicy driverMatchingPolicy = new DriverMatchingPolicy(new DistanceCalculator());

        Rider rider = new Rider("R1", new Location(0, 0));

        Driver driver1 = new Driver("D1", new Location(1, 1));
        driver1.startRide();

        Driver driver2 = new Driver("D2", new Location(4, 5));
        Driver driver6 = new Driver("D23", new Location(2, 3));
        Driver driver7 = new Driver("D24", new Location(2, 2));
        Driver driver8 = new Driver("D25", new Location(2, 2));
        Driver driver3 = new Driver("D3", new Location(2, 2));
        Driver driver4 = new Driver("D4", new Location(8, 7));

        List<Driver> matchedDrivers = driverMatchingPolicy.selectMatches(rider,
                new ArrayList<Driver>(List.of(driver1, driver2, driver3, driver4, driver6, driver7, driver8)));
        matchedDrivers.forEach(System.out::println);
    }

}