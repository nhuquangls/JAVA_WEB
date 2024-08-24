package org.codegym.motel_management.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringDateSwap {
    public static LocalDate stringToLocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter);
    }

    public static String localDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
