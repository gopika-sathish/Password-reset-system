package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    App system = new App();

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOTP() {
        system.generateOTP();
        system.resetPassword("0000", "newpass123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeakPassword() {
        String otp = system.generateOTP();
        system.resetPassword(otp, "123");
    }

    @Test
    public void testValidResetFlow() {
        String otp = system.generateOTP();
        String result = system.resetPassword(otp, "securePass");
        assertEquals("Password Reset Successful", result);
    }
}
