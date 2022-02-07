package com.zara.PricesApi;

import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.router.PricesController;
import com.zara.PricesApi.services.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(MockitoExtension.class)
public class PricesControllerTest {

    @InjectMocks
    PricesController pricesController;

    @Mock
    PriceService priceService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(pricesController)
                .build();
    }

    @Test
    void contextLoad() {
        assertThat(pricesController).isNotNull();
    }

    @Test
    void tryGet() throws Exception {
        InputMock input = MockInputParams.getNinePmOnDayFourteenInput();
        when(priceService.getBy(input.date, input.brandId, input.productId)).thenReturn(new PricesResponseDto());
        pricesController.get(input.date, input.brandId, input.productId);
    }

    @Test
    void tryGetRequest() throws Exception {
        InputMock input = MockInputParams.getNinePmOnDayFourteenInput();
        given(priceService.getBy(input.date, input.brandId, input.productId)).willReturn(PriceDtoMother.getPriceResponseDto(input.date, input.brandId, input.productId));
        String endpoint = String.format("/prices?from=%s&brand=%s&product=%s", input.date, input.brandId, input.productId);

        MockHttpServletResponse response = mockMvc.perform(get(endpoint).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}