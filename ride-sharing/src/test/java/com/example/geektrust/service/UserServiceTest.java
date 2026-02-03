package com.example.geektrust.service;

import com.example.geektrust.domain.valueobject.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    private static final UserService userService = new UserService();

    @Test
    void addRider() {
        userService.createRider("R1", new Location(2, 4));
        assertEquals(1, userService.getRiders().size());
    }
}
