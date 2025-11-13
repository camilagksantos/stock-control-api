package com.study.stock_control_api.controller.mapper;

import com.study.stock_control_api.dto.request.ProductRequestDTO;
import com.study.stock_control_api.dto.response.ProductResponseDTO;
import com.study.stock_control_api.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductRequestDTO dto);

    ProductResponseDTO toResponseDTO(Product product);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDTO(ProductRequestDTO dto, @MappingTarget Product product);
}
