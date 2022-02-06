package com.zara.PricesApi.repository.specification;

import com.zara.PricesApi.entities.PricesEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class PriceSpecification {

    public static Specification<PricesEntity> filteredByStartDateAndBrandIdAndProductId(String startDate, String brandId, String productId) {
        return new GenericSpecification()
                .with("brandId", SearchOperation.EQUALITY, brandId)
                .with("productId", SearchOperation.EQUALITY, productId)
                .with("startDate", SearchOperation.GREATER_THAN, LocalDateTime.parse(startDate, ISO_LOCAL_DATE_TIME))
                .build();
    }
}
