package ru.astashov.rshbtest.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.astashov.rshbtest.dto.CreditAppDto;
import ru.astashov.rshbtest.entity.CreditAppEntity;
import ru.astashov.rshbtest.repository.CreditAppRepository;
import ru.astashov.rshbtest.util.ModelConverter;
import ru.astashov.rshbtest.util.ProductStatistic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CreditAppService {

    private final CreditAppRepository creditAppRepository;
    private final ModelConverter modelConverter;

    public List<CreditAppDto> findAll() {
        return creditAppRepository.findAll()
                .stream()
                .map(modelConverter::convertCreditAppEntityToDto)
                .collect(Collectors.toList());
    }

    public List<CreditAppDto> findNotVrfBySubProduct(String subProduct) {
        List<CreditAppEntity> creditAppEntityList = creditAppRepository.findNotVrfBySubProduct(subProduct);
        List<CreditAppDto> creditAppDtoList = creditAppEntityList
                .stream()
                .map(modelConverter::convertCreditAppEntityToDto)
                .collect(Collectors.toList());

        return creditAppDtoList;
    }

    public List<ProductStatistic> findTopProductsByPeriod(String appDateStart, String appDateEnd) {
        Timestamp timestampStart = new Timestamp(System.currentTimeMillis());
        Timestamp timestampEnd = new Timestamp(System.currentTimeMillis());

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date parsedDateStart = dateFormat.parse(appDateStart);
            Date parsedDateEnd = dateFormat.parse(appDateEnd);
            timestampStart = new java.sql.Timestamp(parsedDateStart.getTime());
            timestampEnd = new java.sql.Timestamp(parsedDateEnd.getTime());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return creditAppRepository.findProductsTopByAppTimestampBetween(timestampStart, timestampEnd);
    }

    public List<CreditAppDto> findExpiredDscByDays(int days) {
        List<CreditAppEntity> creditAppEntityList = creditAppRepository.findExpiredDscByDays(days);
        List<CreditAppDto> creditAppDtoList = creditAppEntityList
                .stream()
                .map(modelConverter::convertCreditAppEntityToDto)
                .collect(Collectors.toList());

        return creditAppDtoList;
    }

}
