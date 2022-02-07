package com.zara.PricesApi.services;

import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.exception.PriceNotFoundException;
import com.zara.PricesApi.exception.PricePriorityException;
import com.zara.PricesApi.mapstruct.MapStructMapperImp;
import com.zara.PricesApi.repository.PricesRepository;
import com.zara.PricesApi.repository.specification.PriceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public PricesResponseDto getBy(LocalDateTime startDate, String brandId, String productId) throws Exception {
            Specification<PricesEntity> spec = PriceSpecification.filteredByStartDateAndBrandIdAndProductId(startDate, brandId, productId);
            List<PricesEntity> pricesEntities = repository.findAll(spec);
            if (!pricesEntities.isEmpty()) {
                return getPriceDto(pricesEntities);
            }
            else {
                throw new PriceNotFoundException(productId, startDate.toString());
            }
    }

    private PricesResponseDto getPriceDto(List<PricesEntity> pricesEntities) throws Exception {
        if (pricesEntities.size() == 1) {
            return structMapper.pricesToPricesResponseDto(pricesEntities.get(0));
        }
        else return getPriorityPriceDto(pricesEntities);
    }

    private PricesResponseDto getPriorityPriceDto(List<PricesEntity> pricesEntities) {
        Optional<PricesEntity> pricesDto = pricesEntities.stream().filter(i -> i.getPriority().equals(1)).findFirst();
        if (pricesDto.isPresent()) {
            return structMapper.pricesToPricesResponseDto(pricesDto.get());
        }
        throw new PricePriorityException("Multiple high priority prices.");
    }
}
