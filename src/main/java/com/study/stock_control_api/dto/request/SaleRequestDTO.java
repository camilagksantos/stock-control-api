package com.study.stock_control_api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record SaleRequestDTO(
        @NotBlank(message = "Customer name is required")
        String customerName,

        @NotEmpty(message = "Items list cannot be empty")
        @Valid
        List<SaleItemRequestDTO> items
) { }
