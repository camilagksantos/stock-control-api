package com.study.stock_control_api.controller.mapper;

import com.study.stock_control_api.dto.request.UserRequestDTO;
import com.study.stock_control_api.dto.response.UserResponseDTO;
import com.study.stock_control_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", ignore = true)
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toResponseDTO(User user);

    @Mapping(target = "userId", ignore = true)
    void updateEntityFromDTO(UserRequestDTO dto, @MappingTarget User user);
}
