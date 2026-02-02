package com.example.geektrust.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static final UserService userService = UserService.getInstance();

    @Test
    void addRider() {
        String[] riderDetails = new String[] { "R1", "2", "4"};
        userService.createRider(riderDetails);

        assertEquals(1, userService.getRiders().size());
    }
}
