package com.codegym.utils;

import com.codegym.config.Config;

import java.util.regex.Pattern;

public class ValidateUtils {

    private static final String REGEX_NAME_CUSTOMER = "^[A-Za-z][A-Za-z]{7,19}$";
    private static final String REGEX_NAME_PRODUCT = "^[A-Za-z][A-Za-z]{9,49}$";

    private static final String REGEX_ADDRESS = "^[A-Za-z0-9][A-Za-z0-9]{14,49}$";
    public static boolean isValidName(String name, String type) {
        String typeRegex = null;
        switch (type) {
            case Config.REGEX_CUSTOMER:
                typeRegex = REGEX_NAME_CUSTOMER;
                break;
            case Config.REGEX_PRODUCT:
                typeRegex = REGEX_NAME_PRODUCT;
                break;
        }
        return Pattern.matches(typeRegex, name);
    }
    public static boolean isValidCustomerAddress(String address) {
        return Pattern.matches(REGEX_ADDRESS, address);
    }

}
