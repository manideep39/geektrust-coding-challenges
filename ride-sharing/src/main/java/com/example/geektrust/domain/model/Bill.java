package com.example.geektrust.domain.model;

import com.example.geektrust.domain.valueobject.RideCharges;

import java.math.BigDecimal;

public class Bill {
    private final Ride ride;
    private final RideCharges rideCharges;
    private final BigDecimal amount;

    public Bill(Ride ride, RideCharges rideCharges, BigDecimal amount) {
        this.ride = ride;
        this.rideCharges = rideCharges;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
