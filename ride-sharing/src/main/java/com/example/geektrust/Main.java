package com.example.geektrust;

import com.example.geektrust.controller.BillController;
import com.example.geektrust.controller.RideController;
import com.example.geektrust.controller.UserController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        RideController rideController = new RideController();
        BillController billController = new BillController();

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               String[] input = sc.nextLine().split(" ");
               String inputCommand = input[0];
               String[] inputDetails = Arrays.copyOfRange(input, 1, input.length);
               switch (inputCommand) {
                   case "ADD_RIDER" -> userController.createRider(inputDetails);
                   case "ADD_DRIVER" -> userController.createDriver(inputDetails);
                   case "MATCH" -> rideController.match(inputDetails);
                   case "START_RIDE" -> rideController.startRide(inputDetails);
                   case "STOP_RIDE" -> rideController.stopRide(inputDetails);
                   case "BILL" -> billController.bill(inputDetails);
                   default -> throw new IllegalArgumentException("Unknow Command");
               }
            }
            sc.close(); // closes the scanner
        } catch (IOException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
