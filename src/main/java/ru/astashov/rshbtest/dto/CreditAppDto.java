package ru.astashov.rshbtest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditAppDto {

    private Long appNum;
    private Timestamp timestamp;
    private String product;
    private String subProduct;

}
