package com.zara.PricesApi.repository.specification;

import com.zara.PricesApi.entities.PricesEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class PriceSpecification {

    public static Specification<PricesEntity> filteredByStartDateAndBrandIdAndProductId(String date, String brandId, String productId) {
        LocalDateTime localDate = LocalDateTime.parse(date, ISO_LOCAL_DATE_TIME);
        return new CustomSpecification()
                .with("brandId", SearchOperation.EQUALITY, brandId)
                .with("productId", SearchOperation.EQUALITY, productId)
                .with("startDate", SearchOperation.LESS_THAN, localDate)
                .with("endDate", SearchOperation.GREATER_THAN, localDate)
                .build();
    }

    public static Specification<PricesEntity> filteredByDateAndBrandIdAndProductId(String startDate, String endDate, String brandId, String productId) {
        return new CustomSpecification()
                .with("brandId", SearchOperation.EQUALITY, brandId)
                .with("productId", SearchOperation.EQUALITY, productId)
                .with("startDate", SearchOperation.GREATER_THAN, LocalDateTime.parse(startDate, ISO_LOCAL_DATE_TIME))
                .with("endDate", SearchOperation.LESS_THAN, LocalDateTime.parse(endDate, ISO_LOCAL_DATE_TIME))
                .build();
    }
}
