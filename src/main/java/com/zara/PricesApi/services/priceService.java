package com.zara.PricesApi.services;

import com.zara.PricesApi.repository.PricesRepository;
import org.springframework.stereotype.Service;

@Service
public class priceService {

    private PricesRepository repository;

    public priceService(PricesRepository pricesRepository) {
        this.repository = pricesRepository;
    }

}
