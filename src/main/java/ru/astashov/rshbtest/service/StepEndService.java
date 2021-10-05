package ru.astashov.rshbtest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astashov.rshbtest.dto.StepEndDto;
import ru.astashov.rshbtest.entity.StepEndEntity;
import ru.astashov.rshbtest.repository.StepEndRepository;
import ru.astashov.rshbtest.util.ModelConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StepEndService {

    private final StepEndRepository stepEndRepository;
    private final ModelConverter modelConverter;

    public List<StepEndDto> findAll() {
        return stepEndRepository.findAll()
                .stream()
                .map(this::formStepEndEntityToStepEndDto)
                .collect(Collectors.toList());
    }

    public void saveAll(List<StepEndDto> stepEndDtoList) {
        List<StepEndEntity> stepEndEntityList = stepEndDtoList
                .stream()
                .map(this::formStepEndDtoToStepEndEntity)
                .collect(Collectors.toList());

        stepEndRepository.saveAll(stepEndEntityList);
    }

    public StepEndDto add(StepEndDto stepEndDto) {
        StepEndEntity stepEndEntity = stepEndRepository.save(formStepEndDtoToStepEndEntity(stepEndDto));
        return formStepEndEntityToStepEndDto(stepEndEntity);
    }

    private StepEndEntity formStepEndDtoToStepEndEntity(StepEndDto stepEndDto) {
        return StepEndEntity.builder()
                .id(stepEndDto.getId())
                .stepResult(stepEndDto.getStepResult())
                .stepResultNum(stepEndDto.getStepResultNum())
                .build();
    }

    private StepEndDto formStepEndEntityToStepEndDto(StepEndEntity stepEndEntity) {
        return StepEndDto.builder()
                .id(stepEndEntity.getId())
                .stepResult(stepEndEntity.getStepResult())
                .stepResultNum(stepEndEntity.getStepResultNum())
                .build();
    }

}
