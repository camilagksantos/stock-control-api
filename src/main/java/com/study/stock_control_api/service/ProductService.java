package com.study.stock_control_api.service;

import com.study.stock_control_api.controller.mapper.ProductMapper;
import com.study.stock_control_api.dto.request.ProductRequestDTO;
import com.study.stock_control_api.dto.response.ProductResponseDTO;
import com.study.stock_control_api.model.Category;
import com.study.stock_control_api.model.Product;
import com.study.stock_control_api.repository.CategoryRepository;
import com.study.stock_control_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductResponseDTO create(ProductRequestDTO dto) {
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.categoryId()));

        Product product = productMapper.toEntity(dto);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return productMapper.toResponseDTO(product);
    }

    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.categoryId()));

        productMapper.updateEntityFromDTO(dto, product);
        product.setCategory(category);

        Product updatedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(updatedProduct);
    }

    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
