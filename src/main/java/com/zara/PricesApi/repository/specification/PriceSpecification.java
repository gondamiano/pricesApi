package com.zara.PricesApi.repository.specification;

import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.exception.InvalidInputException;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class PriceSpecification {

    public static Specification<PricesEntity> filteredByStartDateAndBrandIdAndProductId(LocalDateTime date, String brandId, String productId) {
        try {
            return new CustomSpecification()
                .with("brandId", SearchOperation.EQUALITY, brandId)
                .with("productId", SearchOperation.EQUALITY, productId)
                .with("startDate", SearchOperation.LESS_THAN, date)
                .with("endDate", SearchOperation.GREATER_THAN, date)
                .build();
        }
        catch (Exception e) {
            throw new InvalidInputException();
        }
    }
}
