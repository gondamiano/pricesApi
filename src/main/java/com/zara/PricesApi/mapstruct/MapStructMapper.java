package com.zara.PricesApi.mapstruct;

import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.entities.PricesEntity;

public interface MapStructMapper {

    PricesDto pricesToPricesDto(PricesEntity prices);

    PricesEntity pricesDtoToPrices(PricesDto pricesDto);
}
