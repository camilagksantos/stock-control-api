package com.study.stock_control_api.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponseDTO(
        Long saleId,
        String customerName,
        LocalDateTime saleDate,
        BigDecimal totalAmount,
        List<SaleItemResponseDTO> items
) { }
