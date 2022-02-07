package com.zara.PricesApi.utils;

import com.zara.PricesApi.exception.InvalidInputException;

import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class InputValidator {

    public static boolean validate(String localDateTimeInput, String brandIntengerInput, String productIntengerInput) {
        try {
            LocalDateTime.parse(localDateTimeInput, ISO_LOCAL_DATE_TIME);
            Integer.parseInt(brandIntengerInput);
            Integer.parseInt(productIntengerInput);
            return true;
        }
        catch (Exception e) {
            throw new InvalidInputException(e.getLocalizedMessage());
        }
    }

    public static LocalDateTime getDateFormat(String stringDate) {
        return LocalDateTime.parse(stringDate, ISO_LOCAL_DATE_TIME);
    }
}
