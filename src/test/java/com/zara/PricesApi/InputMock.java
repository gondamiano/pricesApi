package com.zara.PricesApi;

import java.time.LocalDateTime;

public class InputMock {
        public LocalDateTime date;
        public String brandId;
        public String productId;

        InputMock(String date, String brandId, String productId) {
            this.date = LocalDateTime.parse(date);
            this.brandId = brandId;
            this.productId = productId;
        }
}
