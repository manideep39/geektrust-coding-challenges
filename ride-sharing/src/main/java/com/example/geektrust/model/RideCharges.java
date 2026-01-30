package com.example.geektrust.model;

/*
 A base fare of ₹50 is charged for every ride.
 An additional ₹6.5 is charged for every kilometer traveled.
 An additional ₹2 is charged for every minute spent in the ride.
 A service tax of 20% is added to the final amount.
 */

import java.math.BigDecimal;

public class RideCharges {
    private final BigDecimal baseFare;
    private final BigDecimal perKmFare;
    private final BigDecimal perMinFare;
    private final double serviceTax;

    public RideCharges(BigDecimal baseFare, BigDecimal perKmFare, BigDecimal perMinFare, double serviceTax) {
        this.baseFare = baseFare;
        this.perKmFare = perKmFare;
        this.perMinFare = perMinFare;
        this.serviceTax = serviceTax;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public BigDecimal getPerKmFare() {
        return perKmFare;
    }

    public BigDecimal getPerMinFare() {
        return perMinFare;
    }

    public double getServiceTax() {
        return serviceTax;
    }
}
