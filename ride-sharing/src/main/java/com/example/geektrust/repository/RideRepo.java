package com.example.geektrust.repository;

import com.example.geektrust.domain.model.Driver;
import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.model.Rider;

import java.util.*;

public class RideRepo {
    private final List<Ride> rides = new ArrayList<>();
    private final Map<Rider, List<Driver>> matches = new HashMap<>();

    private RideRepo() {}

    public void saveMatches(Rider rider, List<Driver> matchedDrivers) {
        matches.put(rider, matchedDrivers);
    }

    public List<Driver> getMatchedDriversForRider(Rider rider) {
        return matches.get(rider);
    }

    private static class Holder {
        private static final RideRepo INSTANCE = new RideRepo();
    }

    public static RideRepo getInstance() {
        return Holder.INSTANCE;
    }

    public void saveRide(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    public Optional<Ride> getRideById(String rideId) {
        return rides.stream()
                .filter(ride -> ride.getId().equals(rideId))
                .findAny();
    }

}
