package com.example.geektrust.controller;

import com.example.geektrust.application.service.BillService;
import com.example.geektrust.exception.BillException;
import com.example.geektrust.exception.RideException;

public class BillController {
    private final BillService billService = new BillService();

    public void bill(String[] details) {
        try {
            String rideId = details[0];
            String output = billService.bill(rideId);
            System.out.println(output);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough details for bill command");
        } catch (RideException | BillException e) {
            System.out.println(e.getMessage());
        }
    }
}
