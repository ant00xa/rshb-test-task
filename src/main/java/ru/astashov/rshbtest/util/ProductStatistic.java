package ru.astashov.rshbtest.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatistic {
    private String product;
    private Long count;
}
