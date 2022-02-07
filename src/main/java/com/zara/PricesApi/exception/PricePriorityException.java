package com.zara.PricesApi.exception;

public class PricePriorityException extends RuntimeException {
    public PricePriorityException(String message) {
        super(message);
    }

    public PricePriorityException(Exception ex) {
        super(ex);
    }
}
