package com.example.geektrust.domain.valueobject;

/*
 A base fare of ₹50 is charged for every ride.
 An additional ₹6.5 is charged for every kilometer traveled.
 An additional ₹2 is charged for every minute spent in the ride.
 A service tax of 20% is added to the final amount.
 */

public record RideCharges(
        double baseFare,
        double perKmFare,
        double perMinFare,
        double serviceTax
) {
    public RideCharges() {
        this(50, 6.5, 2, 0.2);
    }
}
