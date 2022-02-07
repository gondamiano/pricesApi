package com.zara.PricesApi.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String invalidInput) {
        super(invalidInput);
    }
}
