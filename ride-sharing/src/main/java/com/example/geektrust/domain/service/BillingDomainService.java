package com.example.geektrust.domain.service;

import com.example.geektrust.domain.model.Bill;
import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.valueobject.RideCharges;
import com.example.geektrust.exception.RideException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillingDomainService {
    public Bill billRide(Ride ride, RideCharges rideCharges, DistanceCalculator distanceCalculator) {
        if (!ride.isRideEnded())
            throw new RideException("RIDE_NOT_COMPLETED");

        var amount = BigDecimal.valueOf(
                rideCharges.baseFare() +
                (rideCharges.perKmFare() * ride.getRideDistance(distanceCalculator)) +
                (rideCharges.perMinFare() * ride.getTimeTaken()));
        var serviceTax = amount.multiply(BigDecimal.valueOf(rideCharges.serviceTax()));
        var amountAfterTax = amount.add(serviceTax).setScale(2, RoundingMode.HALF_UP);
        return new Bill(ride, rideCharges, amountAfterTax);
    }
}
