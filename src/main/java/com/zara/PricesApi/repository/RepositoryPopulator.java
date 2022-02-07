package com.zara.PricesApi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zara.PricesApi.dto.PricesDto;
import com.zara.PricesApi.mapstruct.MapStructMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class RepositoryPopulator {

    @Autowired
    private PricesRepository pricesRepository;

    @Bean
    public void fillRepository() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<PricesDto> pricesDtoList = objectMapper.readValue(new File("src/main/resources/data.json"), new TypeReference<>(){});
        pricesRepository.saveAll(new MapStructMapperImp().pricesDtoToPrices(pricesDtoList));
    }
}
