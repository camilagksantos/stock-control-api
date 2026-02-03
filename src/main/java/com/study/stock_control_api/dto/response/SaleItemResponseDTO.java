package com.study.stock_control_api.dto.response;

import java.math.BigDecimal;

public record SaleItemResponseDTO(
        Long saleItemId,
        ProductResponseDTO product,
        Integer quantity,
        BigDecimal unitPrice
) { }
