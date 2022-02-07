package com.zara.PricesApi.services;

import com.zara.PricesApi.InputMock;
import com.zara.PricesApi.MockInputParams;
import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.repository.PricesRepository;
import com.zara.PricesApi.repository.RepositoryPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import(RepositoryPopulator.class)
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class PriceServiceTest {

    @Autowired
    PriceService priceService;

    @Autowired
    PricesRepository repository;

    @Test
    public void should_find_four_prices_in_repository() {
        List<PricesEntity> prices = repository.findAll();
        assertEquals(4, prices.size());
    }

    @Test
    public void should_request_at_ten_am_on_day_fourteen() throws Exception {
        //input
        InputMock input = MockInputParams.getTenAmOnDayFourteenInput();
        PricesResponseDto pricesDto = priceService.getBy(input.date, input.brandId, input.productId);
        assertEquals(input.brandId, pricesDto.brandId.toString());
        assertEquals(input.productId, pricesDto.getProductId().toString());
        System.out.println(pricesDto.toString());
    }

    @Test
    public void should_request_at_four_pm_on_day_fourteen() throws Exception {
        //input
        InputMock input = MockInputParams.getFourPmOnDayFourteenInput();
        PricesResponseDto pricesDto = priceService.getBy(input.date, input.brandId, input.productId);
        assertEquals(input.brandId, pricesDto.brandId.toString());
        assertEquals(input.productId, pricesDto.getProductId().toString());
        System.out.println(pricesDto.toString());
    }

    @Test
    public void should_request_at_nine_pm_on_day_fourteen() throws Exception {
        //input
        InputMock input = MockInputParams.getNinePmOnDayFourteenInput();
        PricesResponseDto pricesDto = priceService.getBy(input.date, input.brandId, input.productId);
        assertEquals(input.brandId, pricesDto.brandId.toString());
        assertEquals(input.productId, pricesDto.getProductId().toString());
        System.out.println(pricesDto.toString());
    }

    @Test
    public void should_request_at_ten_am_on_day_fifteen() throws Exception {
        //input
        InputMock input = MockInputParams.getTenAmOnDayFifteenInput();
        PricesResponseDto pricesDto = priceService.getBy(input.date, input.brandId, input.productId);
        assertEquals(input.brandId, pricesDto.brandId.toString());
        assertEquals(input.productId, pricesDto.getProductId().toString());
        System.out.println(pricesDto.toString());
    }

    @Test
    public void should_request_at_nine_pm_on_day_sixteen() throws Exception {
        //input
        InputMock input = MockInputParams.getNinePmOnDaySixteenInput();
        PricesResponseDto pricesDto = priceService.getBy(input.date, input.brandId, input.productId);
        assertEquals(input.brandId, pricesDto.brandId.toString());
        assertEquals(input.productId, pricesDto.getProductId().toString());
        System.out.println(pricesDto.toString());
    }

    @Test(expected = Exception.class)
    public void should_return_exception() throws Exception {
        //input
        InputMock input = MockInputParams.getNinePmOnDaySixteenInput();
        PricesResponseDto pricesDto = priceService.getBy("2022-05-03T21:00:00", input.brandId, input.productId);
    }
}