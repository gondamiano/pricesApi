package com.zara.PricesApi.constant;

import org.jetbrains.annotations.NotNull;

public enum Brand {

    ZARA("ZARA", 1),
    ZARAHOME("ZARA HOME", 2),
    PULLBEAR("PULL&BEAR", 3),
    BERSHKA("bershka", 4);

    public final String brandName;

    public final Integer brandId;

        Brand(final String brandName, final Integer brandId) {
        this.brandName = brandName;
        this.brandId = brandId;
    }

    public static Brand getById(@NotNull String value) {
        for (Brand brandId : Brand.values()) {
            if (brandId.brandName.equals(value)) {
                return brandId;
            }
        }
        return null;
    }
}
