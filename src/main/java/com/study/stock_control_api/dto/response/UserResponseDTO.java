package com.study.stock_control_api.dto.response;

public record UserResponseDTO(
        Long userId,
        String name,
        String email,
        String role
) { }
