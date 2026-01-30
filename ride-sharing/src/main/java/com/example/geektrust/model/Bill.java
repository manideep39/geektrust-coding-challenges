package com.example.geektrust.model;

import java.math.BigDecimal;

public class Bill {
    private final RideCharges rideCharges;
    private final BigDecimal amount;

    public Bill(RideCharges rideCharges, BigDecimal amount) {
        this.rideCharges = rideCharges;
        this.amount = amount;
    }

    public RideCharges getRideCharges() {
        return rideCharges;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
