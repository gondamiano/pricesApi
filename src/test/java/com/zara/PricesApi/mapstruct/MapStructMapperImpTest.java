package com.zara.PricesApi.mapstruct;

import com.zara.PricesApi.PricesEntityMother;
import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.entities.PricesEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;

class MapStructMapperImpTest {

    List<PricesEntity> pricesEntityList;

    private MapStructMapperImp mapStructMapperImp;

    @BeforeEach
    void prepareProperties() {
        pricesEntityList = new ArrayList<>();
        pricesEntityList.add(PricesEntityMother.getDummyEntity());
        this.mapStructMapperImp = new MapStructMapperImp();
    }

    @Test
    void prices_to_prices_dto() {
        List<PricesDto> pricesDtoList = mapStructMapperImp.pricesToPricesDto(this.pricesEntityList);
        assertFalse(pricesDtoList.isEmpty());
    }

    @Test
    void test_prices_to_prices_dto_with_empty_list() {
        List<PricesDto> pricesDtoList = mapStructMapperImp.pricesToPricesDto(new ArrayList<>());
        assertTrue(pricesDtoList.isEmpty());
    }

    @Test
    void test_prices_to_prices_dto_with_entities() {
        LocalDateTime startDate = LocalDateTime.parse("2020-07-01T20:05:01", ISO_LOCAL_DATE_TIME);
        LocalDateTime endDate = LocalDateTime.parse("2020-07-01T20:05:01", ISO_LOCAL_DATE_TIME);
        this.pricesEntityList.add(PricesEntityMother.getDummyEntity(41.0, "EUR", 501, 204, 13, 1, startDate, endDate));
        List<PricesDto> pricesDtoList = mapStructMapperImp.pricesToPricesDto(this.pricesEntityList);
        assertTrue(pricesDtoList.size() > 1);
    }

}