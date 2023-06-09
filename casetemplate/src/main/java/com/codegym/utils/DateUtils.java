package com.codegym.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String formatLocalDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return formatter.format(localDate);
    }

    public static LocalDate parseStrLocalDate(String strLocalDate) throws DateTimeParseException {
        return LocalDate.parse(strLocalDate, formatter);
    }
    public static boolean isDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.isAfter(startDate) && date.isBefore(endDate);
    }
}
