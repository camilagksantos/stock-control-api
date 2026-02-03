package com.study.stock_control_api.controller.mapper;

import com.study.stock_control_api.dto.response.SaleItemResponseDTO;
import com.study.stock_control_api.dto.response.SaleResponseDTO;
import com.study.stock_control_api.model.Sale;
import com.study.stock_control_api.model.SaleItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleMapper {

    SaleResponseDTO toResponseDTO(Sale sale);

    SaleItemResponseDTO toItemResponseDTO(SaleItem saleItem);
}
