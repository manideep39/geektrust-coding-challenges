package com.example.geektrust.controller;

import com.example.geektrust.service.BillService;
import com.example.geektrust.exception.BillException;
import com.example.geektrust.exception.RideException;

public class BillController {
    private final BillService billService = new BillService();

    public void bill(String[] details) {
        try {
            var rideId = details[0];
            var output = billService.bill(rideId);
            System.out.println(output);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough details for bill command");
        } catch (RideException | BillException e) {
            System.out.println(e.getMessage());
        }
    }
}
