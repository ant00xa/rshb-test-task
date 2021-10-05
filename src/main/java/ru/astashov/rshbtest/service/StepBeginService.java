package ru.astashov.rshbtest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astashov.rshbtest.dto.StepBeginDto;
import ru.astashov.rshbtest.entity.StepBeginEntity;
import ru.astashov.rshbtest.repository.StepBeginRepository;
import ru.astashov.rshbtest.util.ModelConverter;
import ru.astashov.rshbtest.util.Step;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StepBeginService {

    private final StepBeginRepository stepBeginRepository;
    private final ModelConverter modelConverter;

    public StepBeginDto add(StepBeginDto stepBeginDto) {
        StepBeginEntity stepBeginEntity = stepBeginRepository.save(modelConverter.convertStepBeginDtoToEntity(stepBeginDto));
        return modelConverter.convertStepBeginEntityToDto(stepBeginEntity);
    }

    public List<StepBeginDto> findAll() {
        return stepBeginRepository.findAll()
                .stream()
                .map(modelConverter::convertStepBeginEntityToDto)
                .collect(Collectors.toList());
    }

    public void saveAll(List<StepBeginDto> stepBeginDtoList) {
        List<StepBeginEntity> stepBeginEntityList = stepBeginDtoList
                .stream()
                .map(modelConverter::convertStepBeginDtoToEntity)
                .collect(Collectors.toList());

        stepBeginRepository.saveAll(stepBeginEntityList);
    }

    public List<Step> findStepsByCreditApp(Long appNum) {
        return stepBeginRepository.findStepsByCreditApp(appNum);
    }

}
