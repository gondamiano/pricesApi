package com.zara.PricesApi.router;

import com.zara.PricesApi.dto.PricesResponseDto;
import com.zara.PricesApi.services.PriceService;
import com.zara.PricesApi.utils.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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
    public ResponseEntity<PricesResponseDto> get(@RequestParam("date") String stringDate, @RequestParam("brand") String brandId, @RequestParam("product") String productId) throws Exception {
        InputValidator.validate(stringDate, brandId, productId);
        LocalDateTime date = InputValidator.getDateFormat(stringDate);

        PricesResponseDto pricesEntities = priceService.getBy(date, brandId, productId);
        return new ResponseEntity<>(pricesEntities, HttpStatus.OK);
    }
}
