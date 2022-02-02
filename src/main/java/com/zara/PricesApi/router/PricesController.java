package com.zara.PricesApi.router;

import com.zara.PricesApi.entities.PricesEntity;
import com.zara.PricesApi.repository.PricesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest endpoint controller for Prices API
 */
@RestController
public class PricesController {


    /**
     *
     * @return PricesEntity with data from database
     */
    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public List<PricesEntity> get(@RequestParam("from") String startDate, @RequestParam("brand") String brandId, @RequestParam("product") String productId) {
        //price services
        return new ArrayList<>();
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
