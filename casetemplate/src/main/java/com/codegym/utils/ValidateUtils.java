package com.codegym.utils;

import java.util.regex.Pattern;

public class ValidateUtils {

    private static final String REGEX_NAME = "^[A-Za-z][A-Za-z]{7,19}$";


    private static final String REGEX_ADDRESS = "^[A-Za-z0-9][A-Za-z0-9]{14,49}$";
    public static boolean isValidCustomerName(String name) {
        return Pattern.matches(REGEX_NAME, name);
    }
    public static boolean isValidCustomerAddress(String address) {
        return Pattern.matches(REGEX_NAME, address);
    }

}
