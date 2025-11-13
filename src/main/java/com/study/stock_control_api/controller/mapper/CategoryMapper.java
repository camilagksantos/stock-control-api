package com.study.stock_control_api.controller.mapper;

import com.study.stock_control_api.dto.request.CategoryRequestDTO;
import com.study.stock_control_api.dto.response.CategoryResponseDTO;
import com.study.stock_control_api.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "categoryId", ignore = true)
    Category toEntity(CategoryRequestDTO dto);

    CategoryResponseDTO toResponseDTO(Category category);

    @Mapping(target = "categoryId", ignore = true)
    void updateEntityFromDTO(CategoryRequestDTO dto, @MappingTarget Category category);
}
