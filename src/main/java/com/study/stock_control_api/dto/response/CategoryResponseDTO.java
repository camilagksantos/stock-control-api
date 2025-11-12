package com.study.stock_control_api.dto.response;

public class CategoryResponseDTO {
    private Long categoryId;
    private String name;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
