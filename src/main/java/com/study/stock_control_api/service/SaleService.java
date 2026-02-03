package com.study.stock_control_api.service;

import com.study.stock_control_api.controller.mapper.SaleMapper;
import com.study.stock_control_api.dto.request.SaleItemRequestDTO;
import com.study.stock_control_api.dto.request.SaleRequestDTO;
import com.study.stock_control_api.dto.response.SaleResponseDTO;
import com.study.stock_control_api.model.Product;
import com.study.stock_control_api.model.Sale;
import com.study.stock_control_api.model.SaleItem;
import com.study.stock_control_api.repository.ProductRepository;
import com.study.stock_control_api.repository.SaleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.saleMapper = saleMapper;
    }

    @Transactional(readOnly = true)
    public List<SaleResponseDTO> findAll() {
        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public SaleResponseDTO findById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));
        return saleMapper.toResponseDTO(sale);
    }

    @Transactional
    public SaleResponseDTO create(SaleRequestDTO dto) {
        Sale sale = new Sale();
        sale.setCustomerName(dto.customerName());
        sale.setSaleDate(LocalDateTime.now());

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (SaleItemRequestDTO itemDto : dto.items()) {
            Product product = productRepository.findById(itemDto.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemDto.productId()));

            if (product.getAmount() < itemDto.quantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName() +
                        ". Available: " + product.getAmount() + ", Requested: " + itemDto.quantity());
            }

            SaleItem saleItem = new SaleItem();
            saleItem.setProduct(product);
            saleItem.setQuantity(itemDto.quantity());
            saleItem.setUnitPrice(product.getPrice());

            product.setAmount(product.getAmount() - itemDto.quantity());
            productRepository.save(product);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDto.quantity()));
            totalAmount = totalAmount.add(itemTotal);

            sale.addItem(saleItem);
        }

        sale.setTotalAmount(totalAmount);

        Sale savedSale = saleRepository.save(sale);
        return saleMapper.toResponseDTO(savedSale);
    }

    @Transactional
    public void cancel(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + id));

        for (SaleItem item : sale.getItems()) {
            Product product = item.getProduct();
            product.setAmount(product.getAmount() + item.getQuantity());
            productRepository.save(product);
        }

        saleRepository.deleteById(id);
    }
}