package com.zara.PricesApi.mapstruct;

import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.entities.PricesEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Component
public class MapStructMapperImp implements MapStructMapper {

    @Override
    public PricesDto pricesToPricesDto(PricesEntity prices) {
        PricesDto pricesDto = new PricesDto();
        pricesDto.setAmount(prices.getAmount());
        pricesDto.setCurrency(prices.getCurrency());
        pricesDto.setBrandId(prices.getBrandId());
        pricesDto.setPriority(prices.getPriority());
        pricesDto.setPriceListId(prices.getPriceListId());
        pricesDto.setProductId(prices.getProductId());
        pricesDto.setStartDate(prices.getStartDate().toString());
        pricesDto.setEndDate(prices.getEndDate().toString());
        return pricesDto;
    }

    @Override
    public PricesEntity pricesDtoToPrices(PricesDto pricesDto) {
        PricesEntity prices = new PricesEntity();
        prices.setAmount(pricesDto.getAmount());
        prices.setCurrency(pricesDto.getCurrency());
        prices.setBrandId(pricesDto.getBrandId());
        prices.setPriority(pricesDto.getPriority());
        prices.setPriceListId(pricesDto.getPriceListId());
        prices.setProductId(pricesDto.getProductId());
        prices.setStartDate(convertStringToLocalDatetime(pricesDto.getStartDate()));
        prices.setEndDate(convertStringToLocalDatetime(pricesDto.getEndDate()));
        return prices;
    }

    public List<PricesEntity> pricesDtoToPrices(List<PricesDto> pricesDtoList) {
        return pricesDtoList.stream().map(this::pricesDtoToPrices).collect(Collectors.toList());
    }

    public List<PricesDto> pricesToPricesDto(List<PricesEntity> pricesEntityList) {
        return pricesEntityList.stream().map(this::pricesToPricesDto).collect(Collectors.toList());
    }

    LocalDateTime convertStringToLocalDatetime(String date) {
        return LocalDateTime.parse(date, ISO_LOCAL_DATE_TIME);
    }
}
