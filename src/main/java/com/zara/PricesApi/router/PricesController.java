package com.zara.PricesApi.router;

import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<PricesResponseDto> get(@RequestParam("from") String startDate, @RequestParam("brand") String brandId, @RequestParam("product") String productId) throws Exception {
        try {
            PricesResponseDto pricesEntities = priceService.getBy(startDate, brandId, productId);
            return new ResponseEntity<>(pricesEntities, HttpStatus.OK);
        }
        catch (Exception e) {
            throw new Exception("error", e.getCause());
        }

    }
}
