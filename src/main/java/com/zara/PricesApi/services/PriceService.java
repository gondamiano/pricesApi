package com.zara.PricesApi.services;

import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.repository.PricesRepository;
import com.zara.PricesApi.repository.specification.PriceSpecification;
import com.zara.PricesApi.repository.specification.SearchOperation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Service
public class PriceService {

    private PricesRepository repository;

    public PriceService(PricesRepository pricesRepository) {
        this.repository = pricesRepository;
    }

    public List<PricesEntity> getBy(String startDate, String brandId, String productId) {
        List<PricesEntity> pricesEntities = new ArrayList<>();
        try {
            Specification<PricesEntity> spec = this.filtered(startDate, brandId, productId);
            pricesEntities = repository.findAll(spec);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return pricesEntities;
    }

    public Specification<PricesEntity> filtered(String startDate, String brandId, String productId) {
        return new PriceSpecification()
                .with("brandId", SearchOperation.EQUALITY, brandId)
                .with("productId", SearchOperation.EQUALITY, productId)
                .with("startDate", SearchOperation.GREATER_THAN, LocalDateTime.parse(startDate, ISO_LOCAL_DATE_TIME))
                .build();
    }
}
