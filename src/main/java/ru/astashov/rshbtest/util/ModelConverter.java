package ru.astashov.rshbtest.util;

import org.springframework.stereotype.Component;
import ru.astashov.rshbtest.dto.CreditAppDto;
import ru.astashov.rshbtest.entity.CreditAppEntity;
import ru.astashov.rshbtest.dto.StepBeginDto;
import ru.astashov.rshbtest.entity.StepBeginEntity;

@Component
public class ModelConverter {

    public StepBeginEntity convertStepBeginDtoToEntity(StepBeginDto stepBeginDto) {
        return StepBeginEntity.builder()
                .stepId(stepBeginDto.getStepId())
                .stepGuid(stepBeginDto.getStepGuid())
                .subProduct(stepBeginDto.getSubProduct())
                .timestamp(stepBeginDto.getTimestamp())
                .appNum(stepBeginDto.getAppNum())
                .build();
    }

    public StepBeginDto convertStepBeginEntityToDto(StepBeginEntity stepBeginEntity) {
        return StepBeginDto.builder()
                .stepId(stepBeginEntity.getStepId())
                .stepGuid(stepBeginEntity.getStepGuid())
                .subProduct(stepBeginEntity.getSubProduct())
                .timestamp(stepBeginEntity.getTimestamp())
                .appNum(stepBeginEntity.getAppNum())
                .build();
    }

    public CreditAppEntity convertCreditAppDtoToEntity(CreditAppDto creditAppDto) {
        return CreditAppEntity.builder()
                .timestamp(creditAppDto.getTimestamp())
                .appNum(creditAppDto.getAppNum())
                .product(creditAppDto.getProduct())
                .subProduct(creditAppDto.getSubProduct())
                .build();
    }

    public CreditAppDto convertCreditAppEntityToDto(CreditAppEntity creditAppEntity) {
        return CreditAppDto.builder()
                .timestamp(creditAppEntity.getTimestamp())
                .appNum(creditAppEntity.getAppNum())
                .product(creditAppEntity.getProduct())
                .subProduct(creditAppEntity.getSubProduct())
                .build();
    }

}
