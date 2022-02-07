package com.zara.PricesApi;

import com.zara.PricesApi.entities.PricesEntity;

import java.time.LocalDateTime;

    public class PricesEntityMother {

    public static PricesEntity getDummyEntity() {
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setAmount(40.10);
        pricesEntity.setCurrency("EUR");
        pricesEntity.setBrandId(1);
        pricesEntity.setPriority(0);
        pricesEntity.setPriceListId(5014);
        pricesEntity.setProductId(5072);
        pricesEntity.setStartDate(LocalDateTime.MAX);
        pricesEntity.setEndDate(LocalDateTime.MIN);
        return pricesEntity;
    }

    public static PricesEntity getDummyEntity(Double amount, String curr, Integer brandId, Integer productId, Integer priceListId, Integer priority, LocalDateTime startDate, LocalDateTime endDate) {
        PricesEntity pricesEntity = new PricesEntity();
        pricesEntity.setAmount(amount);
        pricesEntity.setCurrency(curr);
        pricesEntity.setBrandId(brandId);
        pricesEntity.setPriority(priority);
        pricesEntity.setPriceListId(priceListId);
        pricesEntity.setProductId(productId);
        pricesEntity.setStartDate(startDate);
        pricesEntity.setEndDate(endDate);
        return pricesEntity;
    }

}
