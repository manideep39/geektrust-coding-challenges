package com.example.geektrust.domain.service;

import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Rider;
import com.example.geektrust.domain.valueobject.DriverDistance;

import java.util.Comparator;
import java.util.List;

public class DriverMatchingPolicy {
    private final int MAX_ALLOWED_DISTANCE = 5;
    private final int MAX_MATCHES = 5;
    private final DistanceCalculator distanceCalculator;

    public DriverMatchingPolicy(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public List<Driver> selectMatches(Rider rider, List<Driver> drivers) {
        return drivers.stream()
                .map(driver -> toCandidate(driver, rider))
                .filter(this::isDriverInAllowedDistance)
                .sorted(rankingComparator())
                .limit(MAX_MATCHES)
                .map(DriverDistance::driver)
                .toList();
    }

    private boolean isDriverInAllowedDistance(DriverDistance dd) {
        return dd.distance() <= MAX_ALLOWED_DISTANCE;
    }

    private Comparator<DriverDistance> rankingComparator() {
        return Comparator.comparingDouble(DriverDistance::distance)
                .thenComparing(dd -> dd.driver().getId());
    }

    private DriverDistance toCandidate(Driver driver, Rider rider) {
        var distance = distanceCalculator.calculate(driver.getLocation(), rider.getLocation());
        return new DriverDistance(driver, distance);
    }
}
