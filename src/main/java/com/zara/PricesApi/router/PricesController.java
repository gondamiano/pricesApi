package com.zara.PricesApi.router;

import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest endpoint controller for Prices API
 */
@RestController
public class PricesController {

    @Autowired
    private PriceService priceService;

    /**
     *
     * @return PricesEntity with data from database
     */
    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public List<PricesEntity> get(@RequestParam("from") String startDate, @RequestParam("brand") String brandId, @RequestParam("product") String productId) {
        List<PricesEntity> pricesEntities = priceService.getBy(startDate, brandId, productId);
        return pricesEntities;
    }

    /**
     *
     * @param pricesEntity
     */
    @PostMapping("/prices")
    public void save(PricesEntity pricesEntity) {
        // create save
        return;
    }
}
