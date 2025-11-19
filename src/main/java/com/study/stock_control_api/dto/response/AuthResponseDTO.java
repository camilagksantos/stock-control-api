package com.study.stock_control_api.dto.response;

public record AuthResponseDTO(
        boolean authenticated,
        String message,
        UserResponseDTO user,
        String token
) {
}
