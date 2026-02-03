package com.example.geektrust.controller;

import com.example.geektrust.application.service.UserService;
import com.example.geektrust.domain.valueobject.Location;
import com.example.geektrust.exception.UserException;

public class UserController {
    private final UserService userService = UserService.getInstance();

    public void createDriver(String[] details) {
        try {
            String driverId = details[0];
            Location location = new Location(Integer.parseInt(details[1]), Integer.parseInt(details[2]));
            userService.createDriver(driverId, location);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NOT_ENOUGH_DETAILS for driver command");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createRider(String[] details) {
        try {
            String riderId = details[0];
            Location location = new Location(Integer.parseInt(details[1]), Integer.parseInt(details[2]));
            userService.createRider(riderId, location);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NOT_ENOUGH_DETAILS for rider command");
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }
}
