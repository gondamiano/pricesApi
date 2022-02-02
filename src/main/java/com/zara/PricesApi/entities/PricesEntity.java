package com.zara.PricesApi.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Prices")
public class PricesEntity {


    private @Id @GeneratedValue Long id;
    @Column(name = "BRAND_ID")
    private Integer brandId;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "PRICE_LIST")
    private Integer priceListId;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE_AMOUNT")
    private Double amount;
    @Column(name = "CURR")
    private String currency;

    public PricesEntity() {

    }
}
