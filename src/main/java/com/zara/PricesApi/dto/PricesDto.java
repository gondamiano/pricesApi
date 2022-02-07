package com.zara.PricesApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesDto {

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
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;

    @Override
    public String toString() {
        return String.format("brandId: %s  -  productId: %s  -  date: %s / %s  -   amount : %s %s", this.brandId, this.productId, this.startDate, this.endDate, this.currency, this.amount);
    }
}
