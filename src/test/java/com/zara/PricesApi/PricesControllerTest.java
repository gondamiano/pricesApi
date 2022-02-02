package com.zara.PricesApi;

import com.zara.PricesApi.router.PricesController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PricesControllerTest {

    @MockBean
    PricesController pricesController;

    @Test
    void contextLoad() throws Exception {
        assertThat(pricesController).isNotNull();
    }
}
