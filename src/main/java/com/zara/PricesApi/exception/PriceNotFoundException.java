package com.zara.PricesApi.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String productId, String date) {
        super(String.format("Price for productId: %s in date: %s not found", productId, date));
    }

    public PriceNotFoundException(String message) {
        super(message);
    }
}
