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
        var userController = new UserController();
        var rideController = new RideController();
        var billController = new BillController();

        try {
            var fis = new FileInputStream(args[0]);
            var sc = new Scanner(fis);
            while (sc.hasNextLine()) {
               var input = sc.nextLine().split(" ");
               var inputCommand = input[0];
               var inputDetails = Arrays.copyOfRange(input, 1, input.length);
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
            sc.close();
        } catch (IOException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
