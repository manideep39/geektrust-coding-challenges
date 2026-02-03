package com.example.geektrust;

import com.example.geektrust.application.service.RideService;
import com.example.geektrust.application.service.UserService;
import com.example.geektrust.controller.RideController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        RideController rideController = new RideController();
        Logger logger = Logger.getLogger(Main.class.getName());

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               String[] input = sc.nextLine().split(" ");
               String[] details = Arrays.copyOfRange(input, 1, input.length);
               switch (input[0]) {
                   case "ADD_RIDER" -> userService.createRider(details);
                   case "ADD_DRIVER" -> userService.createDriver(details);
                   case "MATCH" -> rideController.match(details);
                   case "START_RIDE" -> rideController.startRide(details);
                   case "STOP_RIDE" -> rideController.stopRide(details);
                   default -> throw new IllegalArgumentException("Unknow Command");
               }
            }
            sc.close(); // closes the scanner
        } catch (IOException | IllegalArgumentException e) {
            logger.severe(e.getMessage());
        }
    }
}
