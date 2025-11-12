package com.study.stock_control_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank(message = "Name is required")
        String name
) {}
