package com.zara.PricesApi.repository;

import com.zara.PricesApi.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesRepository extends JpaRepository<PricesEntity, Long> {
}
