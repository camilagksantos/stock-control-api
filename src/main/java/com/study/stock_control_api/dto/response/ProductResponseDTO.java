package com.study.stock_control_api.dto.response;

import java.math.BigDecimal;

public class ProductResponseDTO {
    private Long productId;
    private String name;
    private BigDecimal price;
    private String description;
    private Long amount;
    private CategoryResponseDTO category;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Long productId, String name, BigDecimal price, String description, Long amount, CategoryResponseDTO category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }
}
