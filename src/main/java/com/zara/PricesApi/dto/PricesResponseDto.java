package com.zara.PricesApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesResponseDto {

    @JsonProperty("brandId")
    public Integer brandId;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("priceListId")
    private Integer priceListId;
    @JsonProperty("productId")
    private Integer productId;
    @JsonIgnore()
    private Integer priority;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;

}
