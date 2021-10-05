package ru.astashov.rshbtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StepEndDto {

    private Long id;
    private Timestamp timestamp;
    private int stepResultNum;
    private String stepResult;
    private UUID stepGuid;
    
}
