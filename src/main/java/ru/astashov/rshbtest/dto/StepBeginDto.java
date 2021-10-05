package ru.astashov.rshbtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.astashov.rshbtest.ref.StepId;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StepBeginDto {

    private UUID stepGuid;
    private Long appNum;
    private Timestamp timestamp;
    private String subProduct;
    private StepId stepId;
    
}
