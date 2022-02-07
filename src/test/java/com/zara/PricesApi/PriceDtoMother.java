package com.zara.PricesApi;

import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.dto.PricesResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PriceDtoMother {

    public static PricesDto getPriceDto() {
        PricesDto pricesDto = new PricesDto();
        pricesDto.setAmount(40.10);
        pricesDto.setCurrency("EUR");
        pricesDto.setBrandId(1);
        pricesDto.setPriority(0);
        pricesDto.setPriceListId(5014);
        pricesDto.setProductId(5072);
        pricesDto.setStartDate(LocalDateTime.MAX.toString());
        pricesDto.setEndDate(LocalDateTime.MIN.toString());
        return pricesDto;
    }

    public static PricesDto getPriceDto(Double amount, String curr, Integer brandId, Integer productId, Integer priceListId, Integer priority, String startDate, String endDate) {
        PricesDto pricesDto = new PricesDto();
        pricesDto.setAmount(amount);
        pricesDto.setCurrency(curr);
        pricesDto.setBrandId(brandId);
        pricesDto.setPriority(priority);
        pricesDto.setPriceListId(priceListId);
        pricesDto.setProductId(productId);
        pricesDto.setStartDate(startDate);
        pricesDto.setEndDate(endDate);
        return pricesDto;
    }

    public static PricesResponseDto getPriceResponseDto(String startDate, String brandId, String productId) {
        PricesResponseDto pricesResponseDto = new PricesResponseDto();
        pricesResponseDto.setAmount(41.30);
        pricesResponseDto.setCurrency("EUR");
        pricesResponseDto.setBrandId(Integer.parseInt(brandId));
        pricesResponseDto.setPriority(1);
        pricesResponseDto.setPriceListId(1);
        pricesResponseDto.setProductId(Integer.parseInt(productId));
        pricesResponseDto.setStartDate(startDate);
        pricesResponseDto.setEndDate("2020-06-31T:20:00:00");
        return pricesResponseDto;
    }

    public static List<PricesDto> getDtoList(String startDate, String brandId, String productId) {
        List<PricesDto> pricesDtoList = new ArrayList<>();
        pricesDtoList.add(getPriceDto());
        pricesDtoList.add((getPriceDto(34.5, "EUR", Integer.parseInt(brandId),Integer.parseInt(productId),321, 1, startDate, "2021-07-03")));
        return pricesDtoList;
    }
}
