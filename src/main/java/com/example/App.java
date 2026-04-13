package com.example;

import java.util.Random;

public class App {

    private String generatedOTP;

    // generate OTP
    public String generateOTP() {
        Random random = new Random();
        generatedOTP = String.valueOf(1000 + random.nextInt(9000));
        return generatedOTP;
    }

    // verify OTP
    public boolean verifyOTP(String inputOTP) {
        return generatedOTP != null && generatedOTP.equals(inputOTP);
    }

    // reset password
    public String resetPassword(String otp, String newPassword) {
        if (!verifyOTP(otp)) {
            throw new IllegalArgumentException("Invalid OTP attempt");
        }

        if (newPassword.length() < 6) {
            throw new IllegalArgumentException("Weak password");
        }

        return "Password Reset Successful";
    }

    public static void main(String[] args) {
        App system = new App();

        String otp = system.generateOTP();
        System.out.println("OTP: " + otp);

        System.out.println(system.resetPassword(otp, "newpass123"));
    }
}
