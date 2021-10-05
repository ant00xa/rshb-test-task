package ru.astashov.rshbtest.controller;

import org.springframework.web.bind.annotation.*;
import ru.astashov.rshbtest.dto.CreditAppDto;
import ru.astashov.rshbtest.service.CreditAppService;
import ru.astashov.rshbtest.util.ProductStatistic;

import java.util.List;

@RestController
@RequestMapping("v1")
public class CreditAppController {

    private final CreditAppService creditAppService;

    public CreditAppController(CreditAppService creditAppService) {
        this.creditAppService = creditAppService;
    }

    @GetMapping(path = "credit-apps")
    public List<CreditAppDto> findAll() {
        return creditAppService.findAll();
    }

    @GetMapping(path = "credit-apps/not-vrf")
    public List<CreditAppDto> findNotVrfBySubProduct(@RequestParam(value = "subproduct") String subproduct) {
        return creditAppService.findNotVrfBySubProduct(subproduct);
    }

    @GetMapping(path = "products/top")
    public List<ProductStatistic> findTopProductsByPeriod(@RequestParam(value = "app-date-start") String appDateStart,
                                                          @RequestParam(value = "app-date-end") String appDateEnd) {
        return creditAppService.findTopProductsByPeriod(appDateStart, appDateEnd);
    }

    @GetMapping(path = "credit-apps/expired-dsc")
    public List<CreditAppDto> findExpiredDscByDays(@RequestParam(value = "days") int days) {
        return creditAppService.findExpiredDscByDays(days);
    }

}
