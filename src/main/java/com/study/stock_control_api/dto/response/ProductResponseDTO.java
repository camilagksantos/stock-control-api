package com.study.stock_control_api.dto.response;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long productId,
        String name,
        BigDecimal price,
        String description,
        Long amount,
        CategoryResponseDTO category
) { }
