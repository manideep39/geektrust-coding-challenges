package com.example.geektrust;

import com.example.geektrust.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static final UserService userService = new UserService();

    @Test
    void addRider() {
        String[] riderDetails = new String[] { "R1", "2", "4"};
        userService.createRider(riderDetails);

        assertEquals(1, userService.getRiders().size());
    }
}
