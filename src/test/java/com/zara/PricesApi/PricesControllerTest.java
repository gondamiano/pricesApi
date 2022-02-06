package com.zara.PricesApi;

import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.router.PricesController;
import com.zara.PricesApi.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PricesControllerTest {

    @InjectMocks
    PricesController pricesController;

    @Mock
    PriceService priceService;

    @Test
    void contextLoad() {
        assertThat(pricesController).isNotNull();
    }

    @Test
    void tryGet() {
        String startDate = "20-10-2019", brandId = "123", productId = "PROD23414";
        when(priceService.getBy(startDate, brandId, productId)).thenReturn(new ArrayList<PricesEntity>());
        pricesController.get(startDate, brandId, productId);
    }
}
