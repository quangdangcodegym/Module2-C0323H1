package com.codegym;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestMain {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = "10-06-2023";

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);

        LocalDate a = null;

        // LocalDate to String
        System.out.println(formatter.format(a));



    }
}
