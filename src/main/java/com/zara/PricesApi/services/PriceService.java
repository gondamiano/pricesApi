package com.zara.PricesApi.services;

import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.mapstruct.MapStructMapperImp;
import com.zara.PricesApi.repository.PricesRepository;
import com.zara.PricesApi.repository.specification.PriceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private PricesRepository repository;

    @Autowired
    private MapStructMapperImp structMapper;

    public PriceService(PricesRepository pricesRepository) {
        this.repository = pricesRepository;
    }

    public PricesResponseDto getBy(String startDate, String brandId, String productId) throws Exception {
        try {
            Specification<PricesEntity> spec = PriceSpecification.filteredByStartDateAndBrandIdAndProductId(startDate, brandId, productId);
            List<PricesEntity> pricesEntities = repository.findAll(spec);

            if (!pricesEntities.isEmpty()) {
                return getPriceDto(pricesEntities);
            }
            else {
                throw new Exception("Price not found for specific brand, product and/or date");
            }
        }
        catch (Exception e) {
            throw new Exception("Price");
        }
    }

    private PricesResponseDto getPriceDto(List<PricesEntity> pricesEntities) throws Exception {
        if (pricesEntities.size() == 1) {
            return structMapper.pricesToPricesResponseDto(pricesEntities.get(0));
        }
        else return getPriorityPriceDto(pricesEntities);
    }

    private PricesResponseDto getPriorityPriceDto(List<PricesEntity> pricesEntities) throws Exception {
        Optional<PricesEntity> pricesDto = pricesEntities.stream().filter(i -> i.getPriority().equals(1)).findFirst();
        if (pricesDto.isPresent()) {
            return structMapper.pricesToPricesResponseDto(pricesDto.get());
        }
        throw new Exception("no message");
    }
}
