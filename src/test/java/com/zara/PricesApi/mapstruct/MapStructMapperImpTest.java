package com.zara.PricesApi.mapstruct;

import com.zara.PricesApi.PricesEntityMother;
import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.entities.PricesEntity;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapStructMapperImpTest {

    List<PricesEntity> pricesEntityList;

    @Autowired
    private MapStructMapperImp mapStructMapperImp;

    @Before
    void prepareProperties() {
        pricesEntityList = new ArrayList<>();
        pricesEntityList.add(PricesEntityMother.getDummyEntity());
    }

    @Test
    void pricesToPricesDto() {
    }

    @Test
    void pricesDtoToPrices() {
    }

    @Test
    void testPricesDtoToPrices() {
    }

    @Test
    void testPricesToPricesDto() {
    }

}