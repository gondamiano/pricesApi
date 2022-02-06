package com.zara.PricesApi.services;

import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.mapstruct.MapStructMapperImp;
import com.zara.PricesApi.repository.PricesRepository;
import com.zara.PricesApi.repository.specification.PriceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService {

    private PricesRepository repository;

    @Autowired
    private MapStructMapperImp structMapper;

    public PriceService(PricesRepository pricesRepository) {
        this.repository = pricesRepository;
    }

    public List<PricesDto> getBy(String startDate, String brandId, String productId) {
        try {
            Specification<PricesEntity> spec = PriceSpecification.filteredByStartDateAndBrandIdAndProductId(startDate, brandId, productId);
            List<PricesEntity> pricesEntities = repository.findAll(spec);

            if(!pricesEntities.isEmpty()) {
                List<PricesDto> pricesDtoList = structMapper.pricesToPricesDto(pricesEntities);
                return pricesDtoList;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
