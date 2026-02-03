package com.example.geektrust.service;

import com.example.geektrust.domain.service.BillingDomainService;
import com.example.geektrust.domain.service.DistanceCalculator;
import com.example.geektrust.domain.valueobject.RideCharges;

public class BillService {
    private final BillingDomainService billingDomainService = new BillingDomainService();
    private final RideService rideService = new RideService();
    private final DistanceCalculator distanceCalculator = new DistanceCalculator();

    public String bill(String rideId) {
        var ride = rideService.getRideById(rideId);
        var rideCharges = new RideCharges();
        var bill = billingDomainService.billRide(ride, rideCharges, distanceCalculator);
        return "BILL " + ride.getId() + " " + ride.getDriver().getId() + " " + bill.getAmount();
    }
}
