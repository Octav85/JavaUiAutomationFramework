package com.opencart.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerobject = new Faker();

    public static String generateRandomEmail(String prefix, String sufix) {
        String randomMidPart = String.valueOf(fakerobject.random().nextInt(1, 999999));
        return prefix + randomMidPart + sufix;

    }

    public static String generateRandomEmail() {
        return fakerobject.internet().emailAddress();

    }

    public static String generateFirstName() {
        return fakerobject.name().firstName();
    }

    public static String generateLastName() {
        return fakerobject.name().lastName();
    }

    public static String generatePhoneNumber() {
        return fakerobject.phoneNumber().phoneNumber();
    }

    public static String generatePassword() {
        return fakerobject.internet().password();
    }
}

