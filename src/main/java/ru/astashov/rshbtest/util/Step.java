package ru.astashov.rshbtest.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Step {

    private String stepId;
    private Timestamp timestampBegin;
    private Timestamp timestampEnd;
    private String result;
    private int resultNum;

}
