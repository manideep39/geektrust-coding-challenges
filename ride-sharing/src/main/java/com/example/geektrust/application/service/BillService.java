package com.example.geektrust.application.service;

import com.example.geektrust.domain.model.Bill;
import com.example.geektrust.domain.model.Ride;
import com.example.geektrust.domain.service.BillingDomainService;
import com.example.geektrust.domain.service.DistanceCalculator;
import com.example.geektrust.domain.valueobject.RideCharges;

public class BillService {
    private final BillingDomainService billingDomainService = new BillingDomainService();
    private final RideService rideService = RideService.getInstance();
    private final DistanceCalculator distanceCalculator = new DistanceCalculator();

    public String bill(String rideId) {
        Ride ride = rideService.getRideById(rideId);
        RideCharges rideCharges = new RideCharges();
        Bill bill = billingDomainService.billRide(ride, rideCharges, distanceCalculator);
        return "BILL " + ride.getId() + " " + ride.getDriver().getId() + " " + bill.getAmount();
    }
}
